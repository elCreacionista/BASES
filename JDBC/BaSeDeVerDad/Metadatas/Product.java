package BaSeDeVerDad.Metadatas;

public class Product {

    int id;
    String nom;
    String descripcio;
    double pvp;
    int iva;
    String marca;
    String unitat_mesura;
    double pes;
    Categoria categoria;
    Product(int id, String nom, String descripcio, double pvp, int iva, String marca, String unitat_mesura, double pes, Categoria categoria){
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.pvp = pvp;
        this.iva = iva;
        this.marca = marca;
        this.unitat_mesura = unitat_mesura;
        this.pes = pes;
        this.categoria = categoria;
    }
    /**
     * id
     * nom
     * descripcio
     * pvp
     * iva
     * marca
     * unitat_mesura
     * pes
     * categoria
     */



}
