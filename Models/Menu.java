package Models;

import Enums.Estilos;
import Excepciones.Invalido;
import Excepciones.OpcionNoValida;
import Excepciones.UsuarioPasswordInvalido;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    //region MENU GENERAL
    public static void menuGeneral(TecBeer sistema) {

        sistema.activarSistema();

        int opcion = -1;
        do{
            do{
                Consola.escribir("-----BIENVENIDO-----");
                Consola.escribir("1.LOG IN");
                Consola.escribir("2.REGISTRARSE");
                Consola.escribir("0.SALIR");
                opcion = Consola.leerInt("Seleccione una opcion <!>");
                try {
                    if(opcion < 0 || opcion > 2){
                        throw new OpcionNoValida("Error. Debe ingresar una opción válida");
                    }
                }catch (Exception e){
                    Consola.escribir(e.getMessage());
                }
            }while(opcion < 0 || opcion > 2);

            switch (opcion){
                case 1:
                    logIn(sistema);
                    break;
                case 2:
                    registrarse(sistema);
                    break;
                case 0:
                    sistema.guardarSistema();
                    Consola.escribir("Saliendo del sistema <!>");
                    break;
            }
        }while(opcion!=0);
    }

    //endregion

    //region LOG IN
    public static void logIn(TecBeer sistema) {

        Consola.escribir("-----LOG IN-----");
        Persona personaAux;
        Consola.limpiar();

        try {
            String guardaUser = Consola.leerString("Ingrese usuario: ");
            boolean flagUsuario = sistema.verificarUsuario(guardaUser);
            String guardaPassword = Consola.leerString("Ingrese Password: ");
            boolean flagPassword = sistema.verificarPassword(guardaPassword);

            if(flagPassword && flagUsuario){
                personaAux = sistema.devolverPersonaPorUserName(guardaUser);

                if(personaAux.getRol() == 0){
                    System.out.println("-----MENU USUARIO-----");
                    subMenuUsuario(sistema, (Cliente) personaAux);

                }else{
                    System.out.println("-----MENU ADMIN-----");
                    subMenuAdmin(sistema);
                }
            }else {
                throw new UsuarioPasswordInvalido("Usuario o password incorrecto <!>");
            }
        }catch (Exception e){
            Consola.escribir(e.getMessage());
            Consola.escribir("Presione cualquier tecla para continuar <>");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }

    public static void registrarse(TecBeer sistema){

        Cliente cliente = new Cliente();
        cliente.alta(sistema);
        sistema.addToMapPersona(cliente);
        Consola.escribir("REGISTRO EXITOSO!");
        Consola.escribir("Presione cualquier tecla para continuar <>");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    //endregion

    //region USUARIO
    public static void subMenuUsuario(TecBeer sistema, Cliente cliente){
        int opcion = -1;
        do{
            do{
                Consola.escribir("1.Cliente");
                Consola.escribir("2.Pedido");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>2);

            switch (opcion){
                case 1:
                    usuarioCliente(sistema, cliente);
                    break;
                case 2:
                    usuarioPedido(sistema, cliente);
                    break;
                case 0:
                    break;
            }
        }while(opcion!=0);
    }
    //endregion

    //region ADMIN
    public static void subMenuAdmin(TecBeer sistema) {
        int opcion = -1;
        boolean flag = false;
        do{
            do{
                Consola.escribir("1.Cliente");
                Consola.escribir("2.Pedido");
                Consola.escribir("3.Producto");
                Consola.escribir("4.Liberar sistema");
                Consola.escribir("5.Archivos");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>5);

            switch (opcion){
                case 1:
                    adminCliente(sistema);
                    break;
                case 2:
                    adminPedido(sistema);
                    break;
                case 3:
                    adminProducto(sistema);
                    break;
                case 4:
                    flag = true;
                    sistema.liberarSistema();
                    Consola.escribir("Se libero el sistema <!>");
                    break;
                case 5:
                    subMenuArchivos(sistema);
                    break;
                case 0:
                    if(flag == true){
                        sistema.activarSistema();
                        //VUELVO A ACTIVAR EL SISTEMA EN ESTA PARTE
                        // PORQUE SINO CUANDO SALE DEL PROGRAMA VA A
                        // SOBREESCRIBIR LOS ARCHIVOS CON NULL
                        //SOLO LO VUELVE A ACTIVAR SI ELEGIO LIBERAR SISTEMA
                    }
                    break;
            }
        }while(opcion!=0);

    }
    //endregion

    //region USUARIO - CLIENTE
    public static void usuarioCliente(TecBeer sistema, Cliente cliente){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do{
            do{
                Consola.escribir("1.Ver mi usuario");
                Consola.escribir("2.Baja");
                Consola.escribir("3.Modificar");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>5);

            switch (opcion){
                case 1:
                    Consola.escribir(sistema.devolverPersonaPorUserName(cliente.getUsername()).toString());
                    Consola.escribir("Presione cualquier tecla para continuar");
                    sc.nextLine();
                    break;
                case 2:
                    cliente.baja(sistema, cliente);
                    Consola.escribir("Presione cualquier tecla para continuar");
                    sc.nextLine();
                    break;
                case 3:
                    cliente.modificacion(sistema);
                    Consola.escribir("Se ha modificado exitosamente en el sistema.");
                    Consola.escribir("Presione cualquier tecla para continuar");
                    sc.nextLine();
                    break;
                case 0:
                    break;
            }
        }while(opcion!=0);
    }
    //endregion

    //region USUARIO - PEDIDO
    public static void usuarioPedido(TecBeer sistema, Cliente cliente){
        int opcion = -1;
        do{
            do{
                Consola.escribir("1.Ver pedidos");
                Consola.escribir("2.Hacer pedido");
                Consola.escribir("3.Ver productos");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>4);

            switch (opcion){
                case 1:
                    Consola.escribir("PEDIDOS REALIZADOS");
                    sistema.verPedidosPorCliente(cliente);
                    Consola.escribir("Presione cualquier tecla para continuar");
                    Consola.limpiar();
                    break;
                case 2:
                    Pedido pedido = new Pedido(cliente, sistema);
                    pedido.alta(sistema);
                    sistema.addToMapPedidos(pedido);
                    break;
                case 3:
                    sistema.verTodosLosProductos();
                    break;
                case 0:
                    break;
            }
        }while(opcion!=0);
    }
    //endregion

    //region ADMIN - CLIENTE
    public static void adminCliente(TecBeer sistema){
        Scanner sc = new Scanner(System.in);
        String username;
        int opcion = -1;
        do{
            do{
                Consola.escribir("1.Ver un cliente");
                Consola.escribir("2.Ver todos los clientes");
                Consola.escribir("3.Alta cliente");
                Consola.escribir("4.Alta admin");
                Consola.escribir("5.Baja");
                Consola.escribir("6.Activar cliente");
                Consola.escribir("7.Modificar");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>7);

            switch (opcion){
                case 1:
                    Consola.escribir("Ingrese el Username a buscar: ");
                    username = sc.nextLine();
                    try{
                        if(sistema.devolverPersonaPorUserName(username) != null && sistema.devolverPersonaPorUserName(username) instanceof Cliente){
                            Consola.escribir("CLIENTE: ");
                            Consola.escribir(sistema.devolverPersonaPorUserName(username).toString());
                            Consola.escribir("Presione cualquier tecla para continuar <>");
                            sc.nextLine();
                        }
                        else throw new Invalido("El Username ingresado no pertenece a un cliente válido.");
                    }catch (Invalido e){
                        Consola.escribir(e.getMessage());
                        Consola.escribir("Presione cualquier tecla para continuar <>");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    sistema.verTodosLosClientes();
                    Consola.escribir("Presione cualquier tecla para continuar <>");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 3:
                    Cliente cliente = new Cliente();
                    cliente.alta(sistema);
                    sistema.addToMapPersona(cliente);
                    Consola.escribir("ALTA EXITOSA!");
                    Consola.escribir("Presione cualquier tecla para continuar <>");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 4:
                    Admin admin = new Admin();
                    admin.alta(sistema);
                    sistema.addToMapPersona(admin);
                    Consola.escribir("ALTA ADMIN EXITOSA!");
                    Consola.escribir("Presione cualquier tecla para continuar <>");
                    sc.nextLine();
                    break;
                case 5:
                    Consola.escribir("Ingrese el Username del cliente que desea dar de baja: ");
                    username = sc.nextLine();
                    try{
                        if(sistema.devolverPersonaPorUserName(username) != null && sistema.devolverPersonaPorUserName(username) instanceof Cliente){
                            Persona aux = sistema.devolverPersonaPorUserName(username);
                            aux.setActivo(0);
                            sistema.removeToMapPersona(sistema.devolverPersonaPorUserName(username));
                            sistema.addToMapPersonaInactiva(aux);
                            Consola.escribir("LA BAJA HA SIDO EXITOSA");
                            Consola.escribir("Presione cualquier tecla para continuar<>");
                            sc.nextLine();
                        }else throw new Invalido("El Username ingresado no pertenece a un cliente válido.");
                    }catch (Invalido e){
                        Consola.escribir(e.getMessage());
                    }
                    break;
                case 6:
                    Consola.limpiar();
                    try{
                        String guardaUser = Consola.leerString("Ingrese el userName del cliente a activar");
                        boolean flag = sistema.verificarUsuarioInactivo(guardaUser);
                        if(flag == false){
                            throw new Invalido("El usuario no se encuentra en la base de datos o esta activo <!>");
                        }else{
                            Persona aux = sistema.devolverPersonaInactivaPorUserName(guardaUser);
                            aux.setActivo(1);
                            sistema.addToMapPersona(aux);
                            System.out.println("SE ACTIVO EL CLIENTE!");
                            sc.nextLine();
                        }
                    }catch (Invalido e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    Consola.escribir("Ingrese el Username del cliente que desea modificar: ");
                    username = sc.nextLine();
                    try{
                        if(sistema.devolverPersonaPorUserName(username) != null && sistema.devolverPersonaPorUserName(username) instanceof Cliente){
                            ((Cliente) sistema.devolverPersonaPorUserName(username)).modificacion(sistema);
                            Consola.escribir("SE HA MODIFICADO EL CLIENTE!");
                            Consola.escribir("Presione cualquier tecla para continuar <>");
                            sc.nextLine();
                        }else throw new Invalido("El Username ingresado no pertenece a un cliente válido <!>");
                    }catch (Invalido e){
                        Consola.escribir(e.getMessage());
                        Consola.escribir("Presione cualquier tecla para continuar <>");
                        sc.nextLine();
                    }
                    break;
                case 0:
                    break;
            }
        }while(opcion!=0);
    }
    //endregion

    //region ADMIN - PEDIDO
    public static void adminPedido(TecBeer sistema){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        Persona aux;
        do{
            do{
                Consola.escribir("1.Ver pedidos");
                Consola.escribir("2.Ver todos los pedidos de un cliente");
                Consola.escribir("3.Eliminar pedido");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>3);

            switch (opcion){
                case 1:
                    System.out.println(sistema.verTodosLosPedidos());
                    break;
                case 2:
                    Consola.limpiar();
                    String guardaUser = Consola.leerString("Ingrese el nombre de usuario del cliente");
                    aux=sistema.devolverPersonaPorUserName(guardaUser);
                    sistema.verPedidosPorCliente((Cliente) aux);
                    break;
                case 3:
                    Consola.escribir("PEDIDOS REALIZADOS");
                    System.out.println(sistema.verTodosLosPedidos());
                    Consola.escribir("Ingrese el ID del pedido que desea eliminar: ");
                    int idIngresado = sc.nextInt();
                    sc.nextLine();
                    try {
                        if(sistema.existePedido(idIngresado)){
                            sistema.devolverPedidoPorId(idIngresado).baja(sistema, sistema.devolverPedidoPorId(idIngresado));
                            Consola.escribir("SE HA ELIMINADO EL PEDIDO!");
                            Consola.escribir("Presione cualquier tecla para continuar <>");
                            sc.nextLine();
                        }else throw new Invalido("No existe ningún pedido con el ID ingresado <!>");
                    }catch (Invalido e){
                        Consola.escribir(e.getMessage());
                        Consola.escribir("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    }
                    break;
                case 0:
                    break;
            }
        }while(opcion!=0);
    }
    //endregion

    //region ADMIN - PRODUCTO
    public static void adminProducto(TecBeer sistema){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        int idIngresado;
        do{
            do{
                Consola.escribir("1.Alta");
                Consola.escribir("2.Baja");
                Consola.escribir("3.Modificar");
                Consola.escribir("4.Eliminar");
                Consola.escribir("5.Ver todos los productos");
                Consola.escribir("6.Ver productos por Estilo");
                Consola.escribir("0.Salir");
                opcion=Consola.leerInt("Seleccione una opcion <!>");
            }while(opcion<0||opcion>6);

            switch (opcion){
                case 1:
                    Cerveza cerveza = new Cerveza();
                    cerveza.alta(sistema);
                    sistema.addToMapCerveza(cerveza);
                    Consola.escribir("El nuevo Producto se ha agregado exitosamente a Tecbeer.");
                    Consola.escribir("Presione cualquier tecla para continuar");
                    sc.nextLine();
                    break;
                case 2:
                    char opcionBaja;
                    Consola.escribir("Ingrese el ID del producto que desea dar de baja: ");
                    idIngresado = sc.nextInt();
                    sc.nextLine();
                    try{
                        if(sistema.devolverProductoPorId(idIngresado) != null){
                            Consola.escribir("El ID ingresado pertenece al siguiente producto: ");
                            Consola.escribir(sistema.devolverProductoPorId(idIngresado).toString());
                            Consola.escribir("Desea dar de baja el producto? S/N");
                            String opcionBajaStr = sc.nextLine();
                            opcionBaja = opcionBajaStr.charAt(0);
                            do{
                                if(opcionBaja == 'S'){
                                    sistema.devolverProductoPorId(idIngresado).baja(sistema, sistema.devolverProductoPorId(idIngresado));
                                    Consola.escribir("El producto ha sido dado de baja exitosamente.");
                                    Consola.escribir("Presione cualquier tecla para continuar");
                                    sc.nextLine();
                                }else if (opcionBaja == 'N') break;
                                else {
                                    Consola.escribir("Opción inválida");
                                    Consola.escribir("Desea dar de baja el producto? S/N");
                                    opcionBajaStr = sc.nextLine();
                                    opcionBaja = opcionBajaStr.charAt(0);
                                    if(opcionBaja == 'S'){
                                        sistema.devolverProductoPorId(idIngresado).baja(sistema, sistema.devolverProductoPorId(idIngresado));
                                        Consola.escribir("El producto ha sido dado de baja exitosamente.");
                                        Consola.escribir("Presione cualquier tecla para continuar");
                                        sc.nextLine();
                                    }
                                }
                            }while (opcionBaja != 'N' && opcionBaja != 'S');
                        }else throw new Invalido("El ID ingresado no pertenece a un producto válido.");
                    }catch (Exception e){
                        Consola.escribir(e.getMessage());
                        Consola.escribir("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    }
                    break;
                case 3:
                    Consola.escribir("Ingrese el ID del producto que desea modificar: ");
                    idIngresado = sc.nextInt();
                    sc.nextLine();
                    try{
                        if(sistema.devolverProductoPorId(idIngresado) != null){
                            Consola.escribir("El ID ingresado pertenece al siguiente producto: ");
                            Consola.escribir(sistema.devolverProductoPorId(idIngresado).toString());
                            sistema.devolverProductoPorId(idIngresado).modificacion(sistema);
                            Consola.escribir("El producto ha sido modificado exitosamente.");
                            Consola.escribir("Presione cualquier tecla para continuar");
                            sc.nextLine();
                        }else throw new Invalido("El ID ingresado no pertenece a un producto válido.");
                    }catch (Exception e){
                        Consola.escribir(e.getMessage());
                        Consola.escribir("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    }
                    break;
                case 4:
                    char opcionEliminar;
                    Consola.escribir("Ingrese el ID del producto que desea eliminar: ");
                    idIngresado = sc.nextInt();
                    sc.nextLine();
                    try{
                        if(sistema.devolverProductoPorId(idIngresado) != null){
                            Consola.escribir("El ID ingresado pertenece al siguiente producto: ");
                            Consola.escribir(sistema.devolverProductoPorId(idIngresado).toString());
                            Consola.escribir("Desea eliminar el producto? S/N");
                            String opcionBajaStr = sc.nextLine();
                            opcionBaja = opcionBajaStr.charAt(0);
                            do{
                                if(opcionBaja == 'S'){
                                    sistema.removeToMapCerveza(idIngresado);
                                    Consola.escribir("El producto ha sido eliminado exitosamente.");
                                    Consola.escribir("Presione cualquier tecla para continuar");
                                    sc.nextLine();
                                }else if (opcionBaja == 'N') break;
                                else {
                                    Consola.escribir("Opción inválida");
                                    Consola.escribir("Desea dar de baja el producto? S/N");
                                    opcionBajaStr = sc.nextLine();
                                    opcionBaja = opcionBajaStr.charAt(0);
                                    if(opcionBaja == 'S'){
                                        sistema.removeToMapCerveza(idIngresado);
                                        Consola.escribir("El producto ha sido eliminado exitosamente.");
                                        Consola.escribir("Presione cualquier tecla para continuar");
                                        sc.nextLine();
                                    }
                                }
                            }while (opcionBaja != 'N' && opcionBaja != 'S');
                        }else throw new Invalido("El ID ingresado no pertenece a un producto válido.");
                    }catch (Exception e){
                        Consola.escribir(e.getMessage());
                        Consola.escribir("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    }
                    break;
                case 5:
                    sistema.verTodosLosProductos();
                    Consola.escribir("Presione cualquier tecla para continuar");
                    sc.nextLine();
                    break;
                case 6:
                    Consola.escribir("Ingrese el Estilo de cerveza: ");
                    String estiloIngresado = sc.nextLine().toUpperCase();
                    sc.nextLine();
                    try {
                        Estilos estilos = Estilos.valueOf(estiloIngresado);
                        sistema.verPorEstilo(estiloIngresado);
                        Consola.escribir("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    }catch (IllegalArgumentException e){
                        Consola.escribir("No existen productos con el Estilo ingresado.");
                        Consola.escribir("Presione cualquier tecla para continuar");
                        sc.nextLine();
                    }
                case 0:
                    break;
            }
        }while(opcion!=0);
    }
    //endregion

    //region ARCHIVOS

    public static void subMenuArchivos(TecBeer sistema){
        subMenuVerArchivo(sistema);
    }

    public static void subMenuVerArchivo(TecBeer sistema){
        Scanner c = new Scanner(System.in);
        int option = -1;
        do{
            do{
                Consola.escribir("1.Ver el archivo de personas");
                Consola.escribir("2.Ver el archivo de pedidos");
                Consola.escribir("3.Ver el archivo de Cervezas");
                Consola.escribir("0.Salir");
                option = c.nextInt();

            }while(option < 0 || option > 3);

            switch (option){
                case 1:
                    sistema.verArchivoPersonas();
                    break;
                case 2:
                    sistema.verArchivoPedidos();
                    break;
                case 3:
                    sistema.verArchivoCervezas();
                    break;
                case 0:
                    break;

            }


        }while(option != 0);


    }


    //endregion
}
