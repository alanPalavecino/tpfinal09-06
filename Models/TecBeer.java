package Models;

import Enums.Estilos;
import Excepciones.Invalido;
import Models.Persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TecBeer <T>{

    private ArrayList<T> elementos;//ESTE ARRAYlist SERIA EL GENERAL DE TOOO Y A PARTIR DE ACA DERIVAR A HASHMAP O LO QUE SEA QUE QUERRAMOS TRABAJAR
    private Map<String, Persona> mapPersona;
    private Map<String, ArrayList<Cerveza>> mapCerveza;

    public TecBeer() {
        this.elementos = new ArrayList<>();
        this.mapPersona = new HashMap<>();
        this.mapCerveza = new HashMap<>();
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

    public void addToMapCerveza(Cerveza nuevaCerveza){mapCerveza.get(nuevaCerveza.getEstilo()).add(nuevaCerveza);}

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
}
