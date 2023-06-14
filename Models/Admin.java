package Models;

import Interfaz.iABM;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends Persona implements iABM {
    public Admin() {
    }

    public Admin(String nombre, String apellido, String username, String password, String email, char genero) {
        super(nombre, apellido, username, password, email, genero, 1);
    }

    @Override
    public void alta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el Nombre: ");
        setNombre(sc.nextLine());
        System.out.println("Ingrese el Apellido: ");
        setApellido(sc.nextLine());
        System.out.println("Ingrese el Username: ");
        setUsername(sc.nextLine());
        System.out.println("Ingrese el Password: ");
        setPassword(sc.nextLine());
        while (!isValidPassword(getPassword())) {
            System.out.println("Contraseña inválida. Asegúrese de que su contraseña tenga al menos una mayúscula, dos números y no menos de ocho caracteres en total.");
            System.out.println("Por favor ingrese una contraseña válida: ");
            setPassword(sc.nextLine());
        }
        System.out.println("Ingrese el Email: ");
        setEmail(sc.nextLine());
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(getEmail());
        while (!matcher.find()) {
            System.out.println("Email inválido. Por favor vuelva a ingresarlo: ");
            setEmail(sc.nextLine());
            matcher = pattern.matcher(getEmail());
        }
        System.out.println("Ingrese el Género (M o F): ");
        setGenero(sc.next().charAt(0));
        while (getGenero() != 'M' && getGenero() != 'F'){
            System.out.println("Género inválido. Por favor vuelva a ingresarlo: ");
            setGenero(sc.next().charAt(0));
        }
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
    public void baja() {

    }

    @Override
    public void modificacion() {

    }
}
