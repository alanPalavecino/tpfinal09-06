package Enums;

public enum Tipo {
    BARRIL_20(20),
    BARRIL_30(30),
    BARRIL_50(50),
    LATA(0.5),
    BOTELLA(1);

    private double litros;
    private double precio;

    Tipo(double litros) {
        this.litros = litros;
        this.precio = (litros*50);
    }

    public double getPrecio() {
        return precio;
    }
}
