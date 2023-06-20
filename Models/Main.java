package Models;

import Enums.Estilos;
import Enums.Tipo;
import Excepciones.Invalido;
import Excepciones.OpcionNoValida;
import Models.*;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException, Invalido {


        TecBeer sistema = new TecBeer();

        ArrayList<Admin> listaAdmins = sistema.jsonToAdminsArray("personas.json");
        for (Admin admin : listaAdmins) {
            sistema.addElementoToArrayList(admin);
        }

        ArrayList<Cliente> listaClientes = sistema.jsonToClientesArray("personas.json");
        for (Cliente cliente : listaClientes) {
            sistema.addElementoToArrayList(cliente);
        }

        ArrayList<Cerveza> listaProductos = sistema.jsonToProductosArray("productos.json");
        for(Cerveza cerveza : listaProductos){
            sistema.addElementoToArrayList(cerveza);
        }

        ArrayList<Pedido> listaPedidos = sistema.jsonToPedidosArray("pedidos.json");
        for(Pedido pedido : listaPedidos){
            sistema.addElementoToArrayList(pedido);
        }

        Menu.menuGeneral(sistema);
    }
}