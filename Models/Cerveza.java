package Models;

import Enums.Estilos;
import Enums.Tipo;
import Interfaz.iABM;

public class Cerveza implements iABM{

    private static int cont = 0;
    private int id;
    private String nombre;
    private Estilos estilo;
    private String marca;
    private Tipo tipo;
    private double precio;
    private int stock;

    public Cerveza() {
        cont++;
        this.id = cont;
    }

    public Cerveza(String nombre, Estilos estilo, String marca, Tipo tipo, int stock) {
        cont++;
        this.id = cont;
        this.nombre = nombre;
        this.estilo = estilo;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = tipo.getPrecio();
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo.name();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo.name();
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

    @Override
    public String toString() {
        return "Cerveza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estilo=" + estilo +
                ", marca='" + marca + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    @Override
    public void alta() {

    }

    @Override
    public void baja(TecBeer sistema, Object objeto) {

    }

    @Override
    public void modificacion(TecBeer sistema) {

    }
}
