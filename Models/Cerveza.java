package Models;

import Interfaz.iABM;

public class Cerveza implements iABM {


    private int id;
    private String nombre;
    private String estilo;
    private String marca;
    private double precio;
    private int stock;

    public Cerveza() {
    }

    public Cerveza(int id, String nombre, String estilo, String marca, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.estilo = estilo;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void alta(){};
    public void baja(){};
    public void modificacion(){};
}
