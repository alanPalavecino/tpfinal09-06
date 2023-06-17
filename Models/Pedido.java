package Models;

import Interfaz.iABM;

import java.util.ArrayList;

public class Pedido implements iABM {

    //    private int idDetallePedido;
    //    private int idCabeceraPedido;
    //private float descuento;
    private static int cont= 999;
    private int idPedido;
    private String fecha;
    private Cliente cliente;
    private ArrayList<Cerveza> cervezas; //No pusimos un atributo id para producto porque ya lo tenemos en el array con cada uno.

    public Pedido() {
        cont++;
        this.idPedido = cont;
    }

    public Pedido(int idPedido, String fecha, Cliente cliente, ArrayList<Cerveza> cervezas) {
        cont++;
        this.idPedido = cont;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cervezas = new ArrayList<>();
    }

    public void alta(TecBeer sistema){};
    public void baja(TecBeer sistema, Object objeto){};
    public void modificacion(TecBeer sistema){};
}
