package BaSeDeVerDad.Metadatas;

import BaSeDeVerDad.Exceptions.NotValidDataException;

import java.util.ArrayList;

public class MetadatasAdministrator {

    ArrayList<Categoria> categories;

    public static void main(String[] args) throws Throwable {
        System.out.println("hola;");

    }

    public void setCategories(ArrayList<Categoria> categories) {
        this.categories = categories;
    }

    public Date getDate(String date){
        Date d;
        try {
            d = new Date(date);
            return d;
        }catch(NotValidDataException nvde){
            System.out.println(nvde.getMessage());

        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new Date();
    }
    public User getUser(int client_number, String full_name, String username, String email, ArrayList<Card> cards){
        return new User(client_number, full_name, username, email, cards);
    }
}
