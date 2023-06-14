package Models;

import Enums.Estilos;
import Excepciones.Invalido;
import Models.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TecBeer <T>{

    //MEJOR TRABAJAR CON UN HASHMAP?
    private ArrayList<T> elementos;//ESTE ARRAYlist SERIA EL GENERAL DE TOOO Y A PARTIR DE ACA DERIVAR A HASHMAP O LO QUE SEA QUE QUERRAMOS TRABAJAR
    private Map<String, Persona> mapPersona;

    public TecBeer() {
        this.elementos = new ArrayList<>();
        this.mapPersona = new HashMap<>();
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
            for(Object elemento:elementos){
                lista+=elemento.toString()+"\n";
            }
        }
        return lista;
    }

    //endregion

    public void addToMap(Persona nuevaPersona){
        mapPersona.put(nuevaPersona.getUsername(), nuevaPersona);
    }

    public Persona devolverPersonaPorUserName(String username){
        Persona aux = null;
        for(Map.Entry<String, Persona> entry:mapPersona.entrySet()){
            if(entry.getValue() instanceof Admin){
                if(entry.getValue().getUsername().equals(username)){
                    System.out.println("ENTRE EN ADMIN");
                    aux = entry.getValue();
                }
            }else if(entry.getValue() instanceof Cliente){
                if(entry.getValue().getUsername().equals(username)){
                    System.out.println("ENTRE EN CLIENTE");
                    aux = entry.getValue();
                }
            }

        }
        return aux;
    }

    public boolean verificarUsuario(String userName) {
        boolean existe = false;
        boolean flag = false;
        for(Map.Entry<String, Persona> entry:mapPersona.entrySet()){
            try {
                if(userName.equals(entry.getKey())){
                    existe = true;
                    break;
                }else{
                    throw new Invalido("El usuario no coincide con ningun cliente <!>");
                }
            }catch (Invalido e){
                System.out.println(e.getMessage());
            }

        }
        return existe;
    }

    public boolean verificarPassword(String password) {
        boolean existe = false;
        for(Map.Entry<String, Persona> entry:mapPersona.entrySet()){
            try{
                if(password.equals(entry.getValue().getPassword())){
                    existe = true;
                    break;
                }else{
                    throw new Invalido("El password no coincide con ningun cliente <!>");
                }
            }catch (Invalido e){
                System.out.println((e.getMessage()));
            }
        }
        return existe;
    }
}
