package Models;

import Excepciones.Invalido;
import Excepciones.UsuarioPasswordInvalido;
import Interfaz.iABM;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente extends Persona implements iABM {

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String username, String password, String email, char genero, int activo) {
        super(nombre, apellido, username, password, email, genero, 0, activo);
    }
    @Override
    public void alta(TecBeer sistema) {
        Scanner sc = new Scanner(System.in);
        Consola.escribir("Ingrese el nombre: ");
        setNombre(sc.nextLine());
        Consola.escribir("Ingrese el Apellido: ");
        setApellido(sc.nextLine());
        Consola.escribir("Ingrese el Username: ");
        String username = sc.nextLine();
        while (sistema.verificarUsuario(username)){
            Consola.escribir("El Username ingresado ya existe, por favor ingrese otro: ");
            username = sc.nextLine();
        }
        setUsername(username);
        try{
            Consola.escribir("Ingrese el Password: ");
            setPassword(sc.nextLine());
            if (!isValidPassword(getPassword())) {
                throw new UsuarioPasswordInvalido("Contraseña inválida. Asegúrese de que su contraseña tenga al menos una mayúscula, dos números y no menos de ocho caracteres en total.");
            }
        }catch (Exception e){
            Consola.escribir(e.getMessage());
        }
        while (!isValidPassword(getPassword())){
            Consola.escribir("Por favor ingrese una contraseña válida: ");
            setPassword(sc.nextLine());
        }
        Consola.escribir("Ingrese el Email: ");
        setEmail(sc.nextLine());
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(getEmail());
        while (!matcher.find()) {
            Consola.escribir("Email inválido. Por favor vuelva a ingresarlo: ");
            setEmail(sc.nextLine());
            matcher = pattern.matcher(getEmail());
        }
        Consola.escribir("Ingrese el Género (M o F): ");
        setGenero(sc.nextLine().charAt(0));
        while (getGenero() != 'M' && getGenero() != 'F'){
            Consola.escribir("Género inválido. Por favor vuelva a ingresarlo: ");
            setGenero(sc.nextLine().charAt(0));
        }
        setRol(0);
        setActivo(1);
    }

    private boolean isValidPassword(String password) {
        int uppercaseCount = 0;
        int numberCount = 0;

        if (password.length() < 8) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isDigit(c)) {
                numberCount++;
            }
        }

        return (uppercaseCount >= 1) && (numberCount >= 2);
    }

    @Override
    public void baja(TecBeer sistema, Object objeto) {
        try {
            sistema.removeToMapPersona((Persona) objeto);
            ((Persona) objeto).setActivo(0);
            sistema.addToMapPersonaInactiva((Persona) objeto);
            if(!sistema.verificarUsuario(((Persona) objeto).getUsername())){
                Consola.escribir("Ha sido dado de baja de Tecbeer.");
            }else throw new Invalido("Error inesperado. No se pudo dar de baja del sistema.");
        }catch (Invalido e){
            Consola.escribir(e.getMessage());
        }
    }

    @Override
    public void modificacion(TecBeer sistema) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            Consola.escribir("Qué desea modificar?");
            Consola.escribir("1.Nombre ");
            Consola.escribir("2.Apellido ");
            Consola.escribir("3.Username ");
            Consola.escribir("4.Password ");
            Consola.escribir("5.Email ");
            Consola.escribir("0.Salir ");
            try{
                opcion = Consola.leerInt("Ingrese la opción que desea modificar: ");
            }catch (InputMismatchException e){
                Consola.escribir("Opción inválida. Debe ingresar solamente números");
            }
        }while (opcion < 0 || opcion > 5);

        switch (opcion) {
            case 1:
                Consola.escribir("Ingrese el nuevo Nombre: ");
                setNombre(sc.nextLine());
                break;
            case 2:
                Consola.escribir("Ingrese el nuevo Apellido: ");
                setApellido(sc.nextLine());
                break;
            case 3:
                Consola.escribir("Ingrese el nuevo Username: ");
                String username = sc.nextLine();
                while (sistema.verificarUsuario(username)){
                    Consola.escribir("El Username ingresado ya existe, por favor ingrese otro: ");
                    username = sc.nextLine();
                }
                setUsername(username);
                break;
            case 4:
                Consola.escribir("Ingrese el nuevo Password: ");
                setPassword(sc.nextLine());
                while (!isValidPassword(getPassword())) {
                    Consola.escribir("Contraseña inválida. Asegúrese de que su contraseña tenga al menos una mayúscula, dos números y no menos de ocho caracteres en total.");
                    Consola.escribir("Por favor ingrese una contraseña válida: ");
                    setPassword(sc.nextLine());
                }
                break;
            case 5:
                Consola.escribir("Ingrese el nuevo Email: ");
                setEmail(sc.nextLine());
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcher = pattern.matcher(getEmail());
                while (!matcher.find()) {
                    Consola.escribir("Email inválido. Por favor vuelva a ingresarlo: ");
                    setEmail(sc.nextLine());
                    matcher = pattern.matcher(getEmail());
                }
                break;
            case 0:
                break;
        }
    }


}
