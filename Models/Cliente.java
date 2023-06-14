package Models;

import Interfaz.iABM;

public class Cliente extends Persona implements iABM {

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String username, String password, String email, char genero) {
        super(nombre, apellido, username, password, email, genero, 0);
    }





    @Override
    public void alta() {

    }

    @Override
    public void baja() {

    }

    @Override
    public void modificacion() {

    }
}
