package Enums;

public enum Tipo {
    BARRIL_20(20),
    BARRIL_30(30),
    BARRIL_50(50),
    LATA(0.5),
    BOTELLA(1);

    private double litros;

    Tipo(double litros) {
        this.litros = litros;
    }

    public double getLitros() {
        return litros;
    }

    public static Tipo obtenerTipo(int opcion) {
        Tipo[] tipos = Tipo.values();
        return tipos[opcion - 1];
    }
}
