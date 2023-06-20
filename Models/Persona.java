package Models;

import Interfaz.iABM;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Models.Consola.sc;

public abstract class Persona implements Serializable {

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

    public Persona(String nombre, String apellido, String username, String password, String email, char genero, int rol, int activo) {
        cont++;
        this.id = cont;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.email = email;
        this.genero = genero;
        this.rol = rol;
        this.activo = activo;
    }

    public int getId() {
        return id;
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

    public void setRol(int rol) {
        this.rol = rol;
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
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(username, persona.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}