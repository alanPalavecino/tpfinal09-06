package Models;

public class Lata extends Cerveza {
    private int miliLitros;

    public Lata() {
    }

    public Lata(int id, String nombre, String estilo, String marca, double precio, int stock, int miliLitros) {
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
