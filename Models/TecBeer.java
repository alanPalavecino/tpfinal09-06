package Models;

import Enums.Estilos;
import Excepciones.Invalido;
import Models.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class TecBeer <T>{

    private ArrayList<T> elementos;//ESTE ARRAYlist SERIA EL GENERAL DE TOOO Y A PARTIR DE ACA DERIVAR A HASHMAP O LO QUE SEA QUE QUERRAMOS TRABAJAR

    private Map<String, Persona> mapPersona;

    private Map<String, ArrayList<Cerveza>> mapCerveza;

    private TreeMap<Integer, Pedido> mapPedidos;

    public TecBeer() {
        this.elementos = new ArrayList<>();
        this.mapPersona = new HashMap<>();
        this.mapCerveza = new HashMap<>();
        this.mapPedidos = new TreeMap<>();
    }

    public Map<String, Persona> getMapPersona() {
        return mapPersona;
    }

    public Map<String, ArrayList<Cerveza>> getMapCerveza() {
        return mapCerveza;
    }

    public TreeMap<Integer, Pedido> getMapPedidos() {
        return mapPedidos;
    }

    //region LISTA GENERICA METODS
    //EN LA CLASE PERSONA LO PODEMOS USAR PARA DAR DE ALTA EL OBJETO Y ACA PARA DARLO DE ALTA EN EL ARRAY
    public void addElementoToArrayList(T nuevElemento){
        //SE PODRIA HACER ACA VALIDACIONES CON EXCEPCIONES PARA VER QUE TOOO LO QUE SE INGRESO ESTA BIEN

        elementos.add(nuevElemento);
    }

    //NO SE SI ESTO SERIA LA BAJA? TENDRIA QUE IMPLEMENTAR LA INTERFAZ ACA TAMBIEN ENTONCES
    public void deletePersonaInArrayList(T elemento){
        //ELEGIR ELIMINAR LA PERSONA POR ALGUN ATRIBUTO COMO EL DNI O ALGO DE ESO
        elementos.remove(elemento);

    }

    public String listarElementos(){
        String lista = "No hay nada que mostrar";
        if(!elementos.isEmpty()){
            lista = "";
            for(Object elemento : elementos){
                lista+=elemento.toString()+"\n";
            }
        }
        return lista;
    }

    //endregion

    public void addToMapPersona(Persona nuevaPersona){
        mapPersona.put(nuevaPersona.getUsername(), nuevaPersona);
    }

    public Persona devolverPersonaPorUserName(String username){
        Persona aux = null;
        for(Map.Entry<String, Persona> entry:mapPersona.entrySet()){
            if(entry.getValue() instanceof Admin){
                if(entry.getValue().getUsername().equals(username)){
                    aux = entry.getValue();
                }
            }else if(entry.getValue() instanceof Cliente){
                if(entry.getValue().getUsername().equals(username)){
                    aux = entry.getValue();
                }
            }

        }
        return aux;
    }

    public void removeToMapPersona(Persona persona) {mapPersona.remove(persona.getUsername());}

    public boolean verificarUsuario(String userName) {
        boolean existe = false;
        for(Map.Entry<String, Persona> entry : mapPersona.entrySet()){
            if(userName.equals(entry.getKey())){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean verificarPassword(String password) {
        boolean existe = false;
        for(Map.Entry<String, Persona> entry : mapPersona.entrySet()){
            if(password.equals(entry.getValue().getPassword())){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public void verTodosLosClientes(){
        for(Map.Entry<String, Persona> entry : mapPersona.entrySet()){
            if(entry.getValue() instanceof Cliente){
                Consola.escribir(entry.getValue().toString());
                Consola.escribir("--------------------------------------------------------------");
            }

        }
    }

    public void arrayListToMapPersona(){
        for(Object objeto : elementos){
            if(objeto instanceof Persona){
                Persona persona = (Persona) objeto;

                try {
                    if(!mapPersona.containsKey(persona.getUsername())){
                        mapPersona.put(persona.getUsername(), persona);
                    }else {
                        throw new Invalido("La persona ya existe en el sistema");
                    }
                }catch (Exception e){
                    Consola.escribir(e.getMessage());
                }
            }
        }
    }

    public void arrayListToMapCerveza(){
        for(Object objeto : elementos){
            if(objeto instanceof Cerveza){
                Cerveza cerveza = (Cerveza) objeto;
                String estilo = cerveza.getEstilo();

                if(!mapCerveza.containsKey(estilo)){
                    mapCerveza.put(estilo, new ArrayList<>());
                }else {
                    mapCerveza.get(estilo).add(cerveza);
                }
            }
        }
    }

    public void arrayListToMapPedidos(){
        for(Object objeto : elementos){
            if(objeto instanceof Pedido){
                Pedido pedido = (Pedido) objeto;

                try {
                    if(!mapPedidos.containsKey(pedido.getIdPedido())){
                        mapPedidos.put(pedido.getIdPedido(), pedido);
                    }else {
                        throw new Invalido("El pedido ya existe en el sistema");
                    }
                }catch (Exception e){
                    Consola.escribir(e.getMessage());
                }
            }
        }
    }

    public void addToMapCerveza(Cerveza nuevaCerveza){mapCerveza.get(nuevaCerveza.getEstilo()).add(nuevaCerveza);}

    public void removeToMapCerveza(int id) {
        for(Map.Entry<String, ArrayList<Cerveza>> entry : mapCerveza.entrySet()){
            for(Cerveza cerveza : entry.getValue()){
                if(cerveza.getId() == id){
                    entry.getValue().remove(cerveza);
                    break;
                }
            }
        }
    }

    public void verTodosLosProductos(){
        for(String estilo : mapCerveza.keySet()){
            Consola.escribir("Listado de Cervezas estilo " + estilo);
            ArrayList<Cerveza> cervezas = mapCerveza.get(estilo);
            for(Cerveza cerveza : cervezas){
                Consola.escribir(cerveza.toString());
            }
            Consola.escribir("--------------------------------------------------------------");
        }
    }

    public Cerveza devolverProductoPorId(int id){
        Cerveza aux = null;
        for(String estilo : mapCerveza.keySet()){
            ArrayList<Cerveza> cervezas = mapCerveza.get(estilo);
            for(Cerveza cerveza : cervezas){
                if(cerveza.getId() == id){
                    aux = cerveza;
                }
            }
        }
        return aux;
    }

    public void verPorEstilo (String estilo){

        for(Map.Entry<String, ArrayList<Cerveza>> entry : mapCerveza.entrySet()){
            String estiloMap = entry.getKey();
            if(estiloMap.equalsIgnoreCase(estilo)){
                ArrayList<Cerveza> cervezas = entry.getValue();
                for(Cerveza cerveza : cervezas){
                    Consola.escribir(cerveza.toString());
                }
                break;
            }
        }
    }

    public void addToMapPedidos(Pedido nuevoPedido){
        mapPedidos.put(nuevoPedido.getIdPedido(), nuevoPedido);
    }

    public String verTodosLosPedidos(){
        String lista = "No hay pedidos";
        if(!mapPedidos.isEmpty()){
            lista = "";
            for(Map.Entry<Integer, Pedido> entry:mapPedidos.entrySet()){
                lista+=entry.getValue().toString()+"\n";
            }
        }
        return lista;

    }

    public void verPedidosPorCliente (Cliente cliente){
        double costoTotalPedidos=0.0;
        for(Map.Entry<Integer, Pedido> entry : mapPedidos.entrySet()){
            if(entry.getValue().getCliente().equals(cliente)){
                Consola.escribir(entry.getValue().toString());
                costoTotalPedidos+=entry.getValue().getCostoPedido();
            }
        }
        System.out.println("Costo total pedidos: "+costoTotalPedidos);
    }

    public void mapPersonaToJSON(Map<String, Persona> mapPersona) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("personas.json"), mapPersona);
            Consola.escribir("Las personas se han guardado correctamente en el archivo JSON.");
        } catch (IOException e) {
            Consola.escribir("Error al guardar las personas en el archivo JSON: " + e.getMessage());
        }
    }

    public void mapCervezaToJSON(Map<String, ArrayList<Cerveza>> mapCerveza) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("productos.json"), mapCerveza);
            Consola.escribir("Los productos se han guardado correctamente en el archivo JSON.");
        } catch (IOException e) {
            Consola.escribir("Error al guardar los productos en el archivo JSON: " + e.getMessage());
        }
    }

    public void mapPedidosToJSON(TreeMap<Integer, Pedido> mapPedidos) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File("pedidos.json"), mapPedidos);
            Consola.escribir("Los pedidos se han guardado correctamente en el archivo JSON.");
        } catch (IOException e) {
            Consola.escribir("Error al guardar los pedidos en el archivo JSON: " + e.getMessage());
        }
    }

    public ArrayList<Admin> jsonToAdminsArray(String archivo) {
        ArrayList<Admin> listaAdmins = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(archivo), JsonObject.class);

            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String key = entry.getKey();
                JsonObject personaJson = entry.getValue().getAsJsonObject();
                int rol = personaJson.get("rol").getAsInt();

                if (rol == 1) {
                    Admin admin = gson.fromJson(personaJson, Admin.class);
                    listaAdmins.add(admin);
                }
            }

        } catch (IOException e) {
            Consola.escribir("Error al leer el archivo JSON de admins: " + e.getMessage());
        }

        return listaAdmins;
    }

    public ArrayList<Cliente> jsonToClientesArray(String archivo) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(archivo), JsonObject.class);

            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String key = entry.getKey();
                JsonObject personaJson = entry.getValue().getAsJsonObject();
                int rol = personaJson.get("rol").getAsInt();

                if (rol == 0) {
                    Cliente cliente = gson.fromJson(personaJson, Cliente.class);
                    listaClientes.add(cliente);
                }
            }

        } catch (IOException e) {
            Consola.escribir("Error al leer el archivo JSON de clientes: " + e.getMessage());
        }

        return listaClientes;
    }

    public ArrayList<Cerveza> jsonToProductosArray(String archivo) {
        ArrayList<Cerveza> cervezas = new ArrayList<>();
        try {
            Gson gson = new Gson();

            File file = new File(archivo);
            FileReader reader = new FileReader(file);

            Type tipoMapa = new TypeToken<Map<String, ArrayList<Cerveza>>>() {}.getType();
            Map<String, ArrayList<Cerveza>> mapa = gson.fromJson(reader, tipoMapa);

            for (ArrayList<Cerveza> lista : mapa.values()) {
                cervezas.addAll(lista);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cervezas;
    }

    public ArrayList<Pedido> jsonToPedidosArray(String archivo) {
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        try {
            Gson gson = new Gson();
            FileReader fileReader = new FileReader(archivo);
            Type tipoMapa = new TypeToken<Map<Integer, Pedido>>() {
            }.getType();
            Map<Integer, Pedido> mapaPedidos = gson.fromJson(fileReader, tipoMapa);
            listaPedidos.addAll(mapaPedidos.values());

            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }

        return listaPedidos;
    }


}
