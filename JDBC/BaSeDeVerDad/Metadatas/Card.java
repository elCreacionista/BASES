package BaSeDeVerDad.Metadatas;

public class Card {
    int number;
    int id;
    Date expiration;
    Type type;

    enum Type{
        Visa,Mastercard,Maestro
    }
}
