import Models.Consola;
import Models.Persona;
import Models.TecBeer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        TecBeer sistema = new TecBeer();
        Persona personaPrueba = new Persona("Octavio", "Lopez", "Oti", "Lopez1503", "lopezortizoctavio@gmail.com", 'M', 1);
        sistema.addPersonaToArrayList(personaPrueba);

        System.out.println(sistema.listarPersonas());
        menuGeneral(sistema);

    }

    public static void menuGeneral(TecBeer sistema){
        /**IMPORTANTE*//*en la seccion de productos*/
        //HAY QUE TRAER TODOS LOS PRODUCTOS QUE SE PUEDEN GUARDAR EN UN TREEMAP
        //VER SI TENEMOS QUE HACER DEVUELTA EL BALANCEADO BINARIO PARA QUE SEA MAS RAPIDA LA BUSQUEDA


        /**IMPORTANTE*/
        //HAY QUE TRAER TODOS LOS CLIENTES DESDE ARCHIVOS CON SUS PEDIDOS Y LOS PRODUCTOS DEL PEDIDO

        //tanto los productos como los clientes se pueden traer desde la clase llamada SISTEMA habria que crear las listas ahi
        int opcion = -1;
        do{
            do{
                Consola.escribir("-----BIENVENIDO-----");
                Consola.escribir("1.LOG IN");
                Consola.escribir("2.REGISTRARSE");
                Consola.escribir("0.SALIR");
                opcion = Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion < 0 || opcion >2);

            switch (opcion){
                case 1:
                    //ACA HAGO EL LOG IN VALIDANDO QUE INGRESE UN USUARIO CORRECTO Y SI ESO SUCEDE AHI QUE VALIDE LA CONTRASENIA
                    logIn(sistema);
                    break;
                case 2:
                    //LA PARTE DE REGISTRARSE ES LA DE CREAR UN NUEVO USUARIO
                    break;
                case 0:
                    Consola.escribir("Saliendo del sistema <!>");
                    break;
            }
        }while(opcion!=0);
    }

    /**COMO TRAER EL LISTADO DE LOS CLIENTES AL METODO LOG IN? ASI PUEDE TRABAJAR CON ESE USUARIO SI ES QUE HACE LOG IN*/
    public static void logIn(TecBeer sistema){

        Consola.escribir("-----LOG IN-----");
        Persona personaAux;

        Consola.limpiar();
        String guardaUser = Consola.leerString("Ingrese usuario: ");

        // HACER TODAS LAS VALIDACIONES (VER QUE NO EXISTA EL MISMO USUARIO EN EL ARRAY CLIENTES) (VALIDACIONES GENERALES DE USERNAME)
        String guardaPassword = Consola.leerString("Ingrese Password: ");
        System.out.println(guardaPassword);
        //SI EXISTE LA PASSWORD ENTRAR AL SISTEMA Y TRAER LA PERSONA MEDIANTE EL USUARIO
        personaAux = sistema.devolverPersonaPorUserName(guardaUser);
        if(personaAux.getRol() == 0){
            //ACA MUESTRO EL MENU PARA USUARIO
            System.out.println("-----MENU USUARIO-----");
            
        }else{
            //ACA MUESTRO EL MENU PARA ADMIN
            System.out.println("-----MENU ADMIN-----");
        }



        /**IMPORTANTE, TENGO QUE TRAER LA LISTA DE TODOS LOS CLIENTES QUE HAYA EN EL SISTEMA*/


        //UNA VEZ QUE SE LOGUEA TENGO QUE VER SI ES ADMIN O USUARIO Y A PARTIR DE AHI DECIDIR QUE HACER



    }


    //COMO PARAMETRO LE TENGO QUE PASAR LA LISTA DE CLIENTES ASI AGREGA OTRO MAS SI ENTRA EN REGISTRARSE
    public static void registrarse(/**ACA LA LISTA DE CLIENTES*/ArrayList<Persona> personasEjemplo, TecBeer sistema){
        //CORRER METODO PARA DAR DE ALTA A UN CLIENTE EN ARRAYLIST
        //LANZAR MENSAJE QUE SE CARGO CORRECTAMENTE

        Consola.escribir("-----REGISTRARSE-----");
        String nombre = Consola.leerString("<> Ingrese nombre: ");
        String apellido = Consola.leerString("<> Ingrese apellido: ");
        String user = Consola.leerString("<> Ingrese usuario: ");
        String password = Consola.leerString("<> Ingrese password: ");
        String email = Consola.leerString("<> Ingrese email: ");
        char genero = Consola.leerString("Ingrese geneor").charAt(0);

        // le pase nuevos parametros que se necesitan
        Persona personaRegistro = new Persona(nombre,apellido,user,password,email, genero, 0);
        sistema.addPersonaToArrayList(personaRegistro);


    }


}