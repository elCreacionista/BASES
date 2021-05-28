package BaSeDeVerDad.Metadatas;

public class Card {
    int number;
    int id;
    Date expiration;
    Type type;

    Card(int id, int number, Date date_expiration, String type){
        this.number = number;
        this.id = id;
        this.expiration = date_expiration;
        switch (type.toLowerCase()) {
            case "visa" -> this.type = Type.Visa;
            case "mastercard" -> this.type = Type.Mastercard;
            case "maestro" -> this.type = Type.Maestro;
            default -> this.type = Type.Visa;
        }
    }

    enum Type{
        Visa,Mastercard,Maestro
    }
}
