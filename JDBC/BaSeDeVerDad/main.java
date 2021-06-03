package BaSeDeVerDad;

import BaSeDeVerDad.INTERFEIS.Interfaz;
import OldDatabase.Database;

public class main {
    public static void main(String[] args) throws Exception {

        Database p = new Database();
        p.CrearConexion();
        new Interfaz(p);

    }
}
