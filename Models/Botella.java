package Models;

public class Botella extends Cerveza {

    private int miliLitros;
    public Botella() {
    }
    public Botella(int id, String nombre, String estilo, String marca, double precio, int stock, int miliLitros) {
        super(id, nombre, estilo, marca, precio, stock);
        this.miliLitros = miliLitros;
    }

    public int getMiliLitros() {
        return miliLitros;
    }

    public void setMiliLitros(int miliLitros) {
        this.miliLitros = miliLitros;
    }
}
