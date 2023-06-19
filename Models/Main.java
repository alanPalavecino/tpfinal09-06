package Models;

import Enums.Estilos;
import Enums.Tipo;
import Excepciones.Invalido;
import Excepciones.OpcionNoValida;
import Models.*;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, Invalido {


        TecBeer sistema = new TecBeer();
        Admin adminPrueba = new Admin("Octavio", "Lopez", "Oti", "Lopez1503", "lopezortizoctavio@gmail.com", 'M');
        Cliente clientePrueba = new Cliente("Pedro", "Perez", "pepe", "pepe123", "pepe@gmail.com", 'M');
        sistema.addElementoToArrayList(adminPrueba);
        sistema.addElementoToArrayList(clientePrueba);

        sistema.addToMapPersona(adminPrueba);
        sistema.addToMapPersona(clientePrueba);

        //region PRODUCTOS HARDCODEADOS Y AGREGADOS A LISTA GENERICA

        Cerveza c1 = new Cerveza("Porter", Estilos.ALE, "Ogham", Tipo.BARRIL_20, 300);
        Cerveza c1a = new Cerveza("Porter", Estilos.ALE, "Ogham", Tipo.BARRIL_30, 300);
        Cerveza c1b = new Cerveza("Porter", Estilos.ALE, "Ogham", Tipo.BARRIL_50, 300);
        Cerveza c1c = new Cerveza("Porter", Estilos.ALE, "Ogham", Tipo.LATA, 300);
        Cerveza c1d = new Cerveza("Porter", Estilos.ALE, "Ogham", Tipo.BOTELLA, 300);

        Cerveza c2 = new Cerveza("Golden Ale", Estilos.ALE, "Brew House", Tipo.BARRIL_20, 300);
        Cerveza c2a = new Cerveza("Golden Ale", Estilos.ALE, "Brew House", Tipo.BARRIL_30, 300);
        Cerveza c2b = new Cerveza("Golden Ale", Estilos.ALE, "Brew House", Tipo.BARRIL_50, 300);
        Cerveza c2c = new Cerveza("Golden Ale", Estilos.ALE, "Brew House", Tipo.LATA, 300);
        Cerveza c2d = new Cerveza("Golden Ale", Estilos.ALE, "Brew House", Tipo.BOTELLA, 300);


        Cerveza c3 = new Cerveza("Kolsch", Estilos.LAGER, "Antares", Tipo.BARRIL_20, 300);
        Cerveza c3a = new Cerveza("Kolsch", Estilos.LAGER, "Antares", Tipo.BARRIL_30, 300);
        Cerveza c3b = new Cerveza("Kolsch", Estilos.LAGER, "Antares", Tipo.BARRIL_50, 300);
        Cerveza c3c = new Cerveza("Kolsch", Estilos.LAGER, "Antares", Tipo.LATA, 300);
        Cerveza c3d = new Cerveza("Kolsch", Estilos.LAGER, "Antares", Tipo.BOTELLA, 300);

        Cerveza c4 = new Cerveza("I.P.A.", Estilos.INDIAN_PALE_ALE, "Escondido", Tipo.BARRIL_20, 300);
        Cerveza c4a = new Cerveza("I.P.A.", Estilos.INDIAN_PALE_ALE, "Escondido", Tipo.BARRIL_30, 300);
        Cerveza c4b = new Cerveza("I.P.A.", Estilos.INDIAN_PALE_ALE, "Escondido", Tipo.BARRIL_50, 300);
        Cerveza c4c = new Cerveza("I.P.A.", Estilos.INDIAN_PALE_ALE, "Escondido", Tipo.LATA, 300);
        Cerveza c4d = new Cerveza("I.P.A.", Estilos.INDIAN_PALE_ALE, "Escondido", Tipo.BOTELLA, 300);

        Cerveza c5 = new Cerveza("Dubbel", Estilos.BELGIAN, "Cheverry", Tipo.BARRIL_20, 300);
        Cerveza c5a = new Cerveza("Dubbel", Estilos.BELGIAN, "Cheverry", Tipo.BARRIL_30, 300);
        Cerveza c5b = new Cerveza("Dubbel", Estilos.BELGIAN, "Cheverry", Tipo.BARRIL_50, 300);
        Cerveza c5c = new Cerveza("Dubbel", Estilos.BELGIAN, "Cheverry", Tipo.LATA, 300);
        Cerveza c5d = new Cerveza("Dubbel", Estilos.BELGIAN, "Cheverry", Tipo.BOTELLA, 300);

        Cerveza c6 = new Cerveza("Triple Neipa", Estilos.NEW_ENGLAND_PALE_ALE, "Sir Hopper", Tipo.BARRIL_20, 300);
        Cerveza c6a = new Cerveza("Triple Neipa", Estilos.NEW_ENGLAND_PALE_ALE, "Sir Hopper", Tipo.BARRIL_30, 300);
        Cerveza c6b = new Cerveza("Triple Neipa", Estilos.NEW_ENGLAND_PALE_ALE, "Sir Hopper", Tipo.BARRIL_50, 300);
        Cerveza c6c = new Cerveza("Triple Neipa", Estilos.NEW_ENGLAND_PALE_ALE, "Sir Hopper", Tipo.LATA, 300);
        Cerveza c6d = new Cerveza("Triple Neipa", Estilos.NEW_ENGLAND_PALE_ALE, "Sir Hopper", Tipo.BOTELLA, 300);

        Cerveza c7 = new Cerveza("Citra a Ciegas", Estilos.ENGLAND_PALE_ALE, "Strange Brewing", Tipo.BARRIL_20, 300);
        Cerveza c7a = new Cerveza("Citra a Ciegas", Estilos.ENGLAND_PALE_ALE, "Strange Brewing", Tipo.BARRIL_30, 300);
        Cerveza c7b = new Cerveza("Citra a Ciegas", Estilos.ENGLAND_PALE_ALE, "Strange Brewing", Tipo.BARRIL_50, 300);
        Cerveza c7c = new Cerveza("Citra a Ciegas", Estilos.ENGLAND_PALE_ALE, "Strange Brewing", Tipo.LATA, 300);
        Cerveza c7d = new Cerveza("Citra a Ciegas", Estilos.ENGLAND_PALE_ALE, "Strange Brewing", Tipo.BOTELLA, 300);

        Cerveza c8 = new Cerveza("Flanders Red", Estilos.SOUR, "Juguetes Perdidos", Tipo.BARRIL_20, 300);
        Cerveza c8a = new Cerveza("Flanders Red", Estilos.SOUR, "Juguetes Perdidos", Tipo.BARRIL_30, 300);
        Cerveza c8b = new Cerveza("Flanders Red", Estilos.SOUR, "Juguetes Perdidos", Tipo.BARRIL_50, 300);
        Cerveza c8c = new Cerveza("Flanders Red", Estilos.SOUR, "Juguetes Perdidos", Tipo.LATA, 300);
        Cerveza c8d = new Cerveza("Flanders Red", Estilos.SOUR, "Juguetes Perdidos", Tipo.BOTELLA, 300);

        Cerveza c9 = new Cerveza("A.P.A.", Estilos.PALE_ALE, "Astor", Tipo.BARRIL_20, 300);
        Cerveza c9a = new Cerveza("A.P.A.", Estilos.PALE_ALE, "Astor", Tipo.BARRIL_30, 300);
        Cerveza c9b = new Cerveza("A.P.A.", Estilos.PALE_ALE, "Astor", Tipo.BARRIL_50, 300);
        Cerveza c9c = new Cerveza("A.P.A.", Estilos.PALE_ALE, "Astor", Tipo.LATA, 300);
        Cerveza c9d = new Cerveza("A.P.A.", Estilos.PALE_ALE, "Astor", Tipo.BOTELLA, 300);

        Cerveza c10 = new Cerveza("Petroleo", Estilos.BARRICA, "Jabalina", Tipo.BARRIL_20, 300);
        Cerveza c10a = new Cerveza("Petroleo", Estilos.BARRICA, "Jabalina", Tipo.BARRIL_30, 300);
        Cerveza c10b = new Cerveza("Petroleo", Estilos.BARRICA, "Jabalina", Tipo.BARRIL_50, 300);
        Cerveza c10c = new Cerveza("Petroleo", Estilos.BARRICA, "Jabalina", Tipo.LATA, 300);
        Cerveza c10d = new Cerveza("Petroleo", Estilos.BARRICA, "Jabalina", Tipo.BOTELLA, 300);

        Cerveza c11 = new Cerveza("Belgian Blonde", Estilos.BELGIAN, "Leffe", Tipo.BARRIL_20, 300);
        Cerveza c11a = new Cerveza("Belgian Blonde", Estilos.BELGIAN, "Leffe", Tipo.BARRIL_30, 300);
        Cerveza c11b = new Cerveza("Belgian Blonde", Estilos.BELGIAN, "Leffe", Tipo.BARRIL_50, 300);
        Cerveza c11c = new Cerveza("Belgian Blonde", Estilos.BELGIAN, "Leffe", Tipo.LATA, 300);
        Cerveza c11d = new Cerveza("Belgian Blonde", Estilos.BELGIAN, "Leffe", Tipo.BOTELLA, 300);

        Cerveza c12 = new Cerveza("Carboheira", Estilos.STOUT, "Kira", Tipo.BARRIL_20, 300);
        Cerveza c12a = new Cerveza("Carboheira", Estilos.STOUT, "Kira", Tipo.BARRIL_30, 300);
        Cerveza c12b = new Cerveza("Carboheira", Estilos.STOUT, "Kira", Tipo.BARRIL_50, 300);
        Cerveza c12c = new Cerveza("Carboheira", Estilos.STOUT, "Kira", Tipo.LATA, 300);
        Cerveza c12d = new Cerveza("Carboheira", Estilos.STOUT, "Kira", Tipo.BOTELLA, 300);

        Cerveza c13 = new Cerveza("England Pale", Estilos.ENGLAND_PALE_ALE, "Dogfish Head", Tipo.BARRIL_20, 300);
        Cerveza c13a = new Cerveza("England Pale", Estilos.ENGLAND_PALE_ALE, "Dogfish Head", Tipo.BARRIL_30, 300);
        Cerveza c13b = new Cerveza("England Pale", Estilos.ENGLAND_PALE_ALE, "Dogfish Head", Tipo.BARRIL_50, 300);
        Cerveza c13c = new Cerveza("England Pale", Estilos.ENGLAND_PALE_ALE, "Dogfish Head", Tipo.LATA, 300);
        Cerveza c13d = new Cerveza("England Pale", Estilos.ENGLAND_PALE_ALE, "Dogfish Head", Tipo.BOTELLA, 300);

        Cerveza c14 = new Cerveza("Imperial Stout", Estilos.IMPERIAL_STOUT, "Sierra Nevada", Tipo.BARRIL_20, 300);
        Cerveza c14a = new Cerveza("Imperial Stout", Estilos.IMPERIAL_STOUT, "Sierra Nevada", Tipo.BARRIL_30, 300);
        Cerveza c14b = new Cerveza("Imperial Stout", Estilos.IMPERIAL_STOUT, "Sierra Nevada", Tipo.BARRIL_50, 300);
        Cerveza c14c = new Cerveza("Imperial Stout", Estilos.IMPERIAL_STOUT, "Sierra Nevada", Tipo.LATA, 300);
        Cerveza c14d = new Cerveza("Imperial Stout", Estilos.IMPERIAL_STOUT, "Sierra Nevada", Tipo.BOTELLA, 300);

        Cerveza c15 = new Cerveza("24.7", Estilos.INDIAN_PALE_ALE, "Patagonia", Tipo.BARRIL_20, 300);
        Cerveza c15a = new Cerveza("24.7", Estilos.INDIAN_PALE_ALE, "Patagonia", Tipo.BARRIL_30, 300);
        Cerveza c15b = new Cerveza("24.7", Estilos.INDIAN_PALE_ALE, "Patagonia", Tipo.BARRIL_50, 300);
        Cerveza c15c = new Cerveza("24.7", Estilos.INDIAN_PALE_ALE, "Patagonia", Tipo.LATA, 300);
        Cerveza c15d = new Cerveza("24.7", Estilos.INDIAN_PALE_ALE, "Patagonia", Tipo.BOTELLA, 300);

        Cerveza c16 = new Cerveza("Maldita Honey", Estilos.ALE, "Baum", Tipo.BARRIL_20, 300);
        Cerveza c16a = new Cerveza("Maldita Honey", Estilos.ALE, "Baum", Tipo.BARRIL_30, 300);
        Cerveza c16b = new Cerveza("Maldita Honey", Estilos.ALE, "Baum", Tipo.BARRIL_50, 300);
        Cerveza c16c = new Cerveza("Maldita Honey", Estilos.ALE, "Baum", Tipo.LATA, 300);
        Cerveza c16d = new Cerveza("Maldita Honey", Estilos.ALE, "Baum", Tipo.BOTELLA, 300);

        Cerveza c17 = new Cerveza("Amber Ale", Estilos.ALE, "Gluck", Tipo.BARRIL_20, 300);
        Cerveza c17a = new Cerveza("Amber Ale", Estilos.ALE, "Gluck", Tipo.BARRIL_30, 300);
        Cerveza c17b = new Cerveza("Amber Ale", Estilos.ALE, "Gluck", Tipo.BARRIL_50, 300);
        Cerveza c17c = new Cerveza("Amber Ale", Estilos.ALE, "Gluck", Tipo.LATA, 300);
        Cerveza c17d = new Cerveza("Amber Ale", Estilos.ALE, "Gluck", Tipo.BOTELLA, 300);

        Cerveza c18 = new Cerveza("Barley Wine", Estilos.BARRICA, "Borneo", Tipo.BARRIL_20, 300);
        Cerveza c18a = new Cerveza("Barley Wine", Estilos.BARRICA, "Borneo", Tipo.BARRIL_30, 300);
        Cerveza c18b = new Cerveza("Barley Wine", Estilos.BARRICA, "Borneo", Tipo.BARRIL_50, 300);
        Cerveza c18c = new Cerveza("Barley Wine", Estilos.BARRICA, "Borneo", Tipo.LATA, 300);
        Cerveza c18d = new Cerveza("Barley Wine", Estilos.BARRICA, "Borneo", Tipo.BOTELLA, 300);

        Cerveza c19 = new Cerveza("N.E", Estilos.NEW_ENGLAND_PALE_ALE, "Itzel Craft Beer", Tipo.BARRIL_20, 300);
        Cerveza c19a = new Cerveza("N.E", Estilos.NEW_ENGLAND_PALE_ALE, "Itzel Craft Beer", Tipo.BARRIL_30, 300);
        Cerveza c19b = new Cerveza("N.E", Estilos.NEW_ENGLAND_PALE_ALE, "Itzel Craft Beer", Tipo.BARRIL_50, 300);
        Cerveza c19c = new Cerveza("N.E", Estilos.NEW_ENGLAND_PALE_ALE, "Itzel Craft Beer", Tipo.LATA, 300);
        Cerveza c19d = new Cerveza("N.E", Estilos.NEW_ENGLAND_PALE_ALE, "Itzel Craft Beer", Tipo.BOTELLA, 300);

        Cerveza c20 = new Cerveza("Blonde Ale", Estilos.ALE, "Gaia", Tipo.BARRIL_20, 300);
        Cerveza c20a = new Cerveza("Blonde Ale", Estilos.ALE, "Gaia", Tipo.BARRIL_30, 300);
        Cerveza c20b = new Cerveza("Blonde Ale", Estilos.ALE, "Gaia", Tipo.BARRIL_50, 300);
        Cerveza c20c = new Cerveza("Blonde Ale", Estilos.ALE, "Gaia", Tipo.LATA, 300);
        Cerveza c20d = new Cerveza("Blonde Ale", Estilos.ALE, "Gaia", Tipo.BOTELLA, 300);



        sistema.addElementoToArrayList(c1);
        sistema.addElementoToArrayList(c1a);
        sistema.addElementoToArrayList(c1b);
        sistema.addElementoToArrayList(c1c);
        sistema.addElementoToArrayList(c1d);

        sistema.addElementoToArrayList(c2);
        sistema.addElementoToArrayList(c2a);
        sistema.addElementoToArrayList(c2b);
        sistema.addElementoToArrayList(c2c);
        sistema.addElementoToArrayList(c2d);

        sistema.addElementoToArrayList(c3);
        sistema.addElementoToArrayList(c3a);
        sistema.addElementoToArrayList(c3b);
        sistema.addElementoToArrayList(c3c);
        sistema.addElementoToArrayList(c3d);

        sistema.addElementoToArrayList(c4);
        sistema.addElementoToArrayList(c4a);
        sistema.addElementoToArrayList(c4b);
        sistema.addElementoToArrayList(c4c);
        sistema.addElementoToArrayList(c4d);

        sistema.addElementoToArrayList(c5);
        sistema.addElementoToArrayList(c5a);
        sistema.addElementoToArrayList(c5b);
        sistema.addElementoToArrayList(c5c);
        sistema.addElementoToArrayList(c5d);

        sistema.addElementoToArrayList(c6);
        sistema.addElementoToArrayList(c6a);
        sistema.addElementoToArrayList(c6b);
        sistema.addElementoToArrayList(c6c);
        sistema.addElementoToArrayList(c6d);

        sistema.addElementoToArrayList(c7);
        sistema.addElementoToArrayList(c7a);
        sistema.addElementoToArrayList(c7b);
        sistema.addElementoToArrayList(c7c);
        sistema.addElementoToArrayList(c7d);

        sistema.addElementoToArrayList(c8);
        sistema.addElementoToArrayList(c8a);
        sistema.addElementoToArrayList(c8b);
        sistema.addElementoToArrayList(c8c);
        sistema.addElementoToArrayList(c8d);

        sistema.addElementoToArrayList(c9);
        sistema.addElementoToArrayList(c9a);
        sistema.addElementoToArrayList(c9b);
        sistema.addElementoToArrayList(c9c);
        sistema.addElementoToArrayList(c9d);

        sistema.addElementoToArrayList(c10);
        sistema.addElementoToArrayList(c10a);
        sistema.addElementoToArrayList(c10b);
        sistema.addElementoToArrayList(c10c);
        sistema.addElementoToArrayList(c10d);

        sistema.addElementoToArrayList(c11);
        sistema.addElementoToArrayList(c11a);
        sistema.addElementoToArrayList(c11b);
        sistema.addElementoToArrayList(c11c);
        sistema.addElementoToArrayList(c11d);

        sistema.addElementoToArrayList(c12);
        sistema.addElementoToArrayList(c12a);
        sistema.addElementoToArrayList(c12b);
        sistema.addElementoToArrayList(c12c);
        sistema.addElementoToArrayList(c12d);

        sistema.addElementoToArrayList(c13);
        sistema.addElementoToArrayList(c13a);
        sistema.addElementoToArrayList(c13b);
        sistema.addElementoToArrayList(c13c);
        sistema.addElementoToArrayList(c13d);

        sistema.addElementoToArrayList(c14);
        sistema.addElementoToArrayList(c14a);
        sistema.addElementoToArrayList(c14b);
        sistema.addElementoToArrayList(c14c);
        sistema.addElementoToArrayList(c14d);

        sistema.addElementoToArrayList(c15);
        sistema.addElementoToArrayList(c15a);
        sistema.addElementoToArrayList(c15b);
        sistema.addElementoToArrayList(c15c);
        sistema.addElementoToArrayList(c15d);

        sistema.addElementoToArrayList(c16);
        sistema.addElementoToArrayList(c16a);
        sistema.addElementoToArrayList(c16b);
        sistema.addElementoToArrayList(c16c);
        sistema.addElementoToArrayList(c16d);

        sistema.addElementoToArrayList(c17);
        sistema.addElementoToArrayList(c17a);
        sistema.addElementoToArrayList(c17b);
        sistema.addElementoToArrayList(c17c);
        sistema.addElementoToArrayList(c17d);

        sistema.addElementoToArrayList(c18);
        sistema.addElementoToArrayList(c18a);
        sistema.addElementoToArrayList(c18b);
        sistema.addElementoToArrayList(c18c);
        sistema.addElementoToArrayList(c18d);

        sistema.addElementoToArrayList(c19);
        sistema.addElementoToArrayList(c19a);
        sistema.addElementoToArrayList(c19b);
        sistema.addElementoToArrayList(c19c);
        sistema.addElementoToArrayList(c19d);

        sistema.addElementoToArrayList(c20);
        sistema.addElementoToArrayList(c20a);
        sistema.addElementoToArrayList(c20b);
        sistema.addElementoToArrayList(c20c);
        sistema.addElementoToArrayList(c20d);


        //endregion


//        System.out.println(sistema.listarElementos());
        Menu.menuGeneral(sistema);
    }
}