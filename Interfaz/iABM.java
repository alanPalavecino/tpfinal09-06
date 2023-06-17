package Interfaz;

import Models.TecBeer;

public interface iABM {
    void alta(TecBeer sistema);
    void baja(TecBeer sistema, Object objeto);
    void modificacion(TecBeer sistema);
}
