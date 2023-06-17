package Enums;

import Excepciones.Invalido;
import Models.Consola;

public enum Estilos {
    LAGER,
    ALE,
    BELGIAN,
    PALE_ALE,
    BARRICA,
    SOUR,
    INDIAN_PALE_ALE,
    NEW_ENGLAND_PALE_ALE,
    ENGLAND_PALE_ALE,
    STOUT,
    IMPERIAL_STOUT;

    public static Estilos obtenerEstilo(int opcion) {
        Estilos[] estilos = Estilos.values();
        return estilos[opcion - 1];
    }
}
