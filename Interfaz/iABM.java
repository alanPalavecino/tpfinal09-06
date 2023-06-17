package Interfaz;

import Models.TecBeer;

public interface iABM {
    void alta();
    void baja(TecBeer sistema, Object objeto);
    void modificacion(TecBeer sistema);
}
