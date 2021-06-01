package BaSeDeVerDad.Metadatas;

import java.util.ArrayList;

public class User {
    int client_number;
    String full_name;
    String username;
    String email;
    ArrayList<Card> cards;
    User(int client_number, String full_name, String username, String email, ArrayList<Card> cards){
        this.client_number = client_number;
        this.full_name = full_name;
        this.username = username;
        this.email = email;
        this.cards = cards;
    }
    User(int client_number, String full_name, String username, String email, Card card){
        this.client_number = client_number;
        this.full_name = full_name;
        this.username = username;
        this.email = email;
        this.cards = new ArrayList<>();
        cards.add(card);
    }

}
