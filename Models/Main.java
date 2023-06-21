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
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        TecBeer sistema = new TecBeer();

        ArrayList<Admin> listaAdmins = sistema.jsonToAdminsArray("personas.json");
        for (Admin admin : listaAdmins) {
            admin.setActivo(1);
            sistema.addElementoToArrayList(admin);
        }

        ArrayList<Cliente> listaClientes = sistema.jsonToClientesArray("personas.json");
        for (Cliente cliente : listaClientes) {
            cliente.setActivo(1);
            sistema.addElementoToArrayList(cliente);
        }

        ArrayList<Cliente> listaClientesInactivos = sistema.jsonToClientesArray("personasInactivas.json");
        for (Cliente cliente : listaClientesInactivos) {
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