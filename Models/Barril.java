package Models;

public class Barril extends Cerveza {
    private int litros;

    public Barril() {
    }

    public Barril(int id, String nombre, String estilo, String marca, double precio, int stock, int litros) {
        super(id, nombre, estilo, marca, precio, stock);
        this.litros = litros;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }
}
