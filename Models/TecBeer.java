package Models;

import Models.Persona;

import java.util.ArrayList;
import java.util.List;

public class TecBeer {

    //MEJOR TRABAJAR CON UN HASHMAP?
    private ArrayList<Persona> personas;//ESTE ARRAYlist SERIA EL GENERAL DE TOOO Y A PARTIR DE ACA DERIVAR A HASHMAP O LO QUE SEA QUE QUERRAMOS TRABAJAR
    private List<Pedido> listaPedidos;
    private List <Cerveza> listaCerveza;
    public TecBeer() {
        this.personas = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
        this.listaCerveza = new ArrayList<>();
    }

    //EN LA CLASE PERSONA LO PODEMOS USAR PARA DAR DE ALTA EL OBJETO Y ACA PARA DARLO DE ALTA EN EL ARRAY
    public void addPersonaToArrayList(Persona nuevaPersona){
        //SE PODRIA HACER ACA VALIDACIONES CON EXCEPCIONES PARA VER QUE TOOO LO QUE SE INGRESO ESTA BIEN

        personas.add(nuevaPersona);
    }

    //NO SE SI ESTO SERIA LA BAJA? TENDRIA QUE IMPLEMENTAR LA INTERFAZ ACA TAMBIEN ENTONCES
    public void deletePersonaInArrayList(Persona persona){
        //ELEGIR ELIMINAR LA PERSONA POR ALGUN ATRIBUTO COMO EL DNI O ALGO DE ESO
        personas.remove(persona);

    }

    public String listarPersonas(){
        String lista = "No hay nada que mostrar";
        if(!personas.isEmpty()){
            lista = "";
            for(Persona persona:personas){
                lista+=persona.toString()+"\n";
            }
        }
        return lista;
    }

    public Persona devolverPersonaPorUserName(String userName){
        Persona aux = null;
        for(Persona persona:personas){
            if(persona.getUsername().equals(userName.toString())){
                aux = persona;
            }
        }
        return aux;


    }
}
