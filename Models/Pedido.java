package Models;

import Enums.Estilos;
import Excepciones.Invalido;
import Excepciones.StockInsuficiente;
import Interfaz.iABM;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pedido implements iABM {

    private int idPedido;
    private String fecha;
    private Cliente cliente;
    private ArrayList<Cerveza> cervezas;
    private double costoPedido;

    public Pedido(Cliente cliente, TecBeer sistema) {
        int cont = sistema.ultimoIdMapPedidos();
        cont++;
        this.idPedido = cont;
        this.cliente = cliente;
        this.cervezas = new ArrayList<>();
        this.costoPedido = 0;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cerveza> getCervezas() {
        return cervezas;
    }

    public void setCervezas(ArrayList<Cerveza> cervezas) {
        this.cervezas = cervezas;
    }

    public double getCostoPedido() {
        return costoPedido;
    }

    public void setCostoPedido(double costoPedido) {
        this.costoPedido = costoPedido;
    }

    @Override
    public String toString() {
        return "\nPedido{" +
                "idPedido=" + idPedido +
                ", fecha='" + fecha + '\'' +
                ", cliente=" + cliente.getId() +
                ", cervezas=" + cervezas +
                ", costoPedido=" + costoPedido +
                '}';
    }

    public String toStringCliente(){
        return "Pedido: "+
                "FECHA: "+fecha +'\''+
                ", CLIENTE: "+cliente.getUsername()+
                ", CERVEZAS: "+cervezas+
                ", COSTO PEDIDO: "+costoPedido;
    }

    public void alta(TecBeer sistema){
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.fecha = formatoFecha.format(fechaActual);
        Scanner sc = new Scanner(System.in);
        char opcion = 'N';
        do{
            int opcionEstilo = 1;
            for(Estilos estilo : Estilos.values()){
                Consola.escribir(opcionEstilo + ". " + estilo);
                opcionEstilo++;
            }
            int estiloElegido;
            do{
                try{
                    Consola.escribir("Seleccione el Estilo de cerveza que desea comprar: ");
                    estiloElegido = sc.nextInt();
                    sc.nextLine();
                    while (estiloElegido < 1 || estiloElegido > Estilos.values().length){
                        Consola.escribir("Opción inválida, por favor ingrese la opción nuevamente: ");
                        estiloElegido = sc.nextInt();
                        sc.nextLine();
                    }
                }catch (InputMismatchException e){
                    while (!sc.hasNextInt()){
                        Consola.escribir("Por favor ingrese solamente numeros: ");
                        sc.next();
                    }
                    estiloElegido = sc.nextInt();
                    sc.nextLine();
                }
            }while (estiloElegido < 1 || estiloElegido > Estilos.values().length);

            sistema.verPorEstilo(Estilos.obtenerEstilo(estiloElegido).name());
            Consola.escribir("Ingrese el ID del producto que desea comprar: ");
            int idIngresado = sc.nextInt();
            sc.nextLine();
            try{
                if(sistema.devolverProductoPorId(idIngresado) != null && sistema.devolverProductoPorId(idIngresado).getActivo() == 1){
                    Consola.escribir("El ID ingresado pertenece al siguiente producto: ");
                    Consola.escribir(sistema.devolverProductoPorId(idIngresado).toString());
                    Consola.escribir("Ingrese la cantidad que desea comprar: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    try{
                        if(sistema.devolverProductoPorId(idIngresado).getStock() > cantidad){
                            cervezas.add(sistema.devolverProductoPorId(idIngresado));

                            costoPedido+=sistema.devolverProductoPorId(idIngresado).getPrecio()*cantidad;

                            int stockActual = sistema.devolverProductoPorId(idIngresado).getStock();
                            sistema.devolverProductoPorId(idIngresado).setStock(stockActual - cantidad);
                            Consola.escribir("La compra se ha realizado exitosamente.");
                            Consola.escribir("Desea comprar más productos? (S/N)");
                            String opcionStr = sc.nextLine().toUpperCase();
                            opcion = opcionStr.charAt(0);
                        }else{
                            throw new StockInsuficiente("No hay stock <!>");
                        }
                    }catch (StockInsuficiente e){
                        Consola.escribir(e.getMessage());
                    }
                }else throw new Invalido("El ID ingresado no pertenece a un producto válido.");
            }catch (Exception e){
                Consola.escribir(e.getMessage());
                Consola.escribir("Presione cualquier tecla para continuar");
                sc.nextLine();
            }
        }while (opcion == 'S');

    }
    public void baja(TecBeer sistema, Object objeto){
        if(objeto instanceof Pedido){
            Pedido aux = (Pedido) objeto;
            sistema.removeFromMapPedidos(aux.getIdPedido());
        }
    }
    public void modificacion(TecBeer sistema){};


}
