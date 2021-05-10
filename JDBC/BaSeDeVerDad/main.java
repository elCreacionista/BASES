package BaSeDeVerDad;

import OldDatabase.Database;
import OldDatabase.Pantalla;

public class main {
    public static void main(String[] args) throws Exception {

        Database p = new Database();
        p.CrearConexion();
        new Interfaz(p);

    }
}
