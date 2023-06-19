package Models;

import Enums.Estilos;
import Enums.Tipo;
import Excepciones.Invalido;
import Interfaz.iABM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cerveza implements iABM{

    private static int cont = 0;
    private int id;
    private String nombre;

    private Estilos estilo;
    private String marca;

    private Tipo tipo;
//    private double precio;
    private Integer stock;

    private int activo;

    public Cerveza() {
        cont++;
        this.id = cont;
    }

    public Cerveza(String nombre, Estilos estilo, String marca, Tipo tipo, Integer stock) {
        cont++;
        this.id = cont;
        this.nombre = nombre;
        this.estilo = estilo;
        this.marca = marca;
        this.tipo = tipo;
//        this.precio = tipo.getPrecio();
        this.stock = stock;
        this.activo = 1;
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

    public void setEstilo(Estilos estilo) {
        this.estilo = estilo;
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

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

//    public double getPrecio() {
//        return precio;
//    }
//
//    public void setPrecio(double precio) {
//        this.precio = precio;
//    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Cerveza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estilo=" + estilo +
                ", marca='" + marca + '\'' +
                ", tipo=" + tipo +
//                ", precio=" + precio +
                ", stock=" + stock +
                ", activo=" + activo +
                '}';
    }

    @Override
    public void alta(TecBeer sistema) {
        Scanner sc = new Scanner(System.in);
        Consola.escribir("Ingrese el Nombre del producto: ");
        setNombre(sc.nextLine());

        Consola.escribir("Seleccione el Estilo: ");
        int opcionEstilo = 1;
        for(Estilos estilo : Estilos.values()){
            Consola.escribir(opcionEstilo + ". " + estilo);
            opcionEstilo++;
        }
        int estiloElegido;
        try{
            estiloElegido = sc.nextInt();
            sc.nextLine();
            while (estiloElegido < 1 || estiloElegido > Estilos.values().length){
                Consola.escribir("Opción inválida, por favor ingrese la opción nuevamente: ");
                estiloElegido = sc.nextInt();
                sc.nextLine();
            }
            Estilos estilo = Estilos.obtenerEstilo(estiloElegido);
            setEstilo(estilo);
        }catch (InputMismatchException e){
            Consola.escribir("Por favor ingrese solamente numeros: ");
            estiloElegido = sc.nextInt();
            sc.nextLine();
            Estilos estilo = Estilos.obtenerEstilo(estiloElegido);
            setEstilo(estilo);
        }
        Consola.escribir("Ingrese la Marca del producto: ");
        sc.nextLine();
        String marca = sc.nextLine();
        setMarca(marca);

        Consola.escribir("Seleccione el Tipo de producto: ");
        int opcionTipo = 1;
        for(Tipo tipo : Tipo.values()){
            Consola.escribir(opcionTipo + ". " + tipo);
            opcionTipo++;
        }
        int tipoElegido;
        try{
            tipoElegido = sc.nextInt();
            while (tipoElegido < 1 || tipoElegido > Tipo.values().length){
                Consola.escribir("Opción inválida, por favor ingrese la opción nuevamente: ");
                tipoElegido = sc.nextInt();
            }
            Tipo tipo = Tipo.obtenerTipo(tipoElegido);
            setTipo(tipo);
        }catch (InputMismatchException e){
            Consola.escribir("Por favor ingrese solamente numeros: ");
            tipoElegido = sc.nextInt();
            Tipo tipo = Tipo.obtenerTipo(tipoElegido);
            setTipo(tipo);
        }

        try {
            Consola.escribir("Ingrese el Stock disponible: ");
            setStock(sc.nextInt());
            sc.nextLine();
        }catch (InputMismatchException e){
            Consola.escribir("Error. Debe ingresar el stock en números enteros.");
            Consola.escribir("Ingrese el Stock disponible: ");
            setStock(sc.nextInt());
        }
        activo = 1;
    }

    @Override
    public void baja(TecBeer sistema, Object objeto) {
        try{
            if(objeto instanceof Cerveza){
                ((Cerveza) objeto).setActivo(0);
            }else throw new Invalido("Error al intentar dar de baja el producto.");
        }catch (Exception e){
            Consola.escribir(e.getMessage());
        }

    }

    @Override
    public void modificacion(TecBeer sistema) {
        Scanner sc  = new Scanner(System.in);
        int opcion = 0;

        do{

            Consola.escribir("¿Qué desea modificar?");
            Consola.escribir("1- Nombre ");
            Consola.escribir("2- Estilo ");
            Consola.escribir("3- Marca ");
            Consola.escribir("4- Tipo ");
            Consola.escribir("5- Stock ");
            Consola.escribir("0-Salir ");

            opcion = sc.nextInt();


        } while (opcion < 0 || opcion > 5);

        switch (opcion){
            case 1:
                Consola.escribir("Ingrese el nuevo nombre");
                setNombre(sc.nextLine());
                break;
            case 2:
                Consola.escribir("Seleccione el Estilo: ");
                int opcionEstilo = 1;
                for(Estilos estilo : Estilos.values()){
                    Consola.escribir(opcionEstilo + ". " + estilo);
                    opcionEstilo++;
                }
                int estiloElegido;
                try{
                    estiloElegido = sc.nextInt();
                    sc.nextLine();
                    while (estiloElegido < 1 || estiloElegido > Estilos.values().length){
                        Consola.escribir("Opción inválida, por favor ingrese la opción nuevamente: ");
                        estiloElegido = sc.nextInt();
                        sc.nextLine();
                    }
                    Estilos estilo = Estilos.obtenerEstilo(estiloElegido);
                    setEstilo(estilo);
                }catch (InputMismatchException e){
                    Consola.escribir("Por favor ingrese solamente numeros: ");
                    estiloElegido = sc.nextInt();
                    sc.nextLine();
                    Estilos estilo = Estilos.obtenerEstilo(estiloElegido);
                    setEstilo(estilo);
                }
                break;
            case 3:
                Consola.escribir("Ingrese la Marca del producto: ");
                sc.nextLine();
                String marca = sc.nextLine();
                setMarca(marca);
                break;
            case 4:
                Consola.escribir("Seleccione el Tipo de producto: ");
                int opcionTipo = 1;
                for(Tipo tipo : Tipo.values()){
                    Consola.escribir(opcionTipo + ". " + tipo);
                    opcionTipo++;
                }
                int tipoElegido;
                try{
                    tipoElegido = sc.nextInt();
                    while (tipoElegido < 1 || tipoElegido > Tipo.values().length){
                        Consola.escribir("Opción inválida, por favor ingrese la opción nuevamente: ");
                        tipoElegido = sc.nextInt();
                    }
                    Tipo tipo = Tipo.obtenerTipo(tipoElegido);
                    setTipo(tipo);
                }catch (InputMismatchException e){
                    Consola.escribir("Por favor ingrese solamente numeros: ");
                    tipoElegido = sc.nextInt();
                    Tipo tipo = Tipo.obtenerTipo(tipoElegido);
                    setTipo(tipo);
                }
                break;
            case 5:
                try {
                    Consola.escribir("Ingrese el Stock disponible: ");
                    setStock(sc.nextInt());
                    sc.nextLine();
                }catch (InputMismatchException e){
                    Consola.escribir("Error. Debe ingresar el stock en números enteros.");
                    Consola.escribir("Ingrese el Stock disponible: ");
                    setStock(sc.nextInt());
                }
                break;
            case 0:
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }

    }
}
