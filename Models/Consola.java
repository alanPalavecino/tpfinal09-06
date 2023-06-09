package Models;

import java.util.Scanner;

public class Consola {
    static Scanner sc = new Scanner(System.in);

    public static void escribir(Object o){
        System.out.println(o);
    }

    public static String leerString(String mensaje){
        Consola.escribir(mensaje);
        return sc.nextLine();
    }

    public static int leerInt(String mensaje){
        Consola.escribir(mensaje);
        return sc.nextInt();
    }

    public static void limpiar(){
        sc.nextLine();
    }
}
