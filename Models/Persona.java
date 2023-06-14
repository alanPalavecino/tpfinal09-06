package Models;

import Interfaz.iABM;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Models.Consola.sc;

public abstract class Persona{

    // agregue algunos parametros
    private static int cont = 0;
    private int id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;
    private char genero;
    private int rol;
    private int activo;

    public Persona() {
        cont++;
        this.id = cont;
    }

    public Persona(String nombre, String apellido, String username, String password, String email, char genero, int rol) {
        cont++;
        this.id = cont;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
        this.genero = genero;
        this.rol = rol;
        this.activo = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int isActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getRol() {
        return rol;
    }
    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "\nid='"+id+'\''+
                "\nnombre='" + nombre + '\'' +
                ", \napellido='" + apellido + '\'' +
                ", \nusername='" + username + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nemail='" + email + '\'' +
                ", \ngenero='" + genero +'\'' +
                ", \nrol=" + rol +
                ", \nactivo=" + activo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(password, persona.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }




    /*//EL ALTA DE PERSONA NO TIENE QUE ESTAR ACA ME PARECE HABRIA QUE CHEQUEAR!!!
    @Override
    public void alta() {
        nombre = Consola.leerString("Ingrese el Nombre: ");
        //AGREGAR VALIDACION DE NOMBRE
        Consola.limpiar();
        apellido = Consola.leerString("Ingrese el Apellido: ");
        //AGREGAR VALIDACION DE APELLIDO
        Consola.limpiar();
        username = Consola.leerString("Ingrese el Username: ");
        //AGREGAR VALIDACION DE USERNAME (QUE NO HAYA OTRO IGUAL)
        Consola.limpiar();
        password = Consola.leerString("Ingrese Password: ");


        //VALIDACION DE PASSWORD
        while (!isValidPassword(password)) {
            System.out.println("Contraseña inválida. Asegúrese de que su contraseña tenga al menos una mayúscula, dos números y no menos de ocho caracteres en total.");
            password = Consola.leerString("Por favor ingrese una contraseña válida: ");
        }
        email = Consola.leerString("Ingrese el Email: ");


        //VALIDACION DE MAIL
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        while (!matcher.find()) {
            email = Consola.leerString("Email inválido. Por favor vuelva a ingresarlo: ");

            matcher = pattern.matcher(email);
        }

        //AL GENERO LO SAQUE PORQUE ME PARECIA AL PEDO

        System.out.println("Ingrese el Género (M o F): ");
        genero = sc.next().charAt(0);
        while (genero != 'M' && genero != 'F') {
            System.out.println("Género inválido. Por favor vuelva a ingresarlo: ");
            genero = sc.next().charAt(0);
        }

        activo = 1;


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

    }*/


}