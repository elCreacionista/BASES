package BaSeDeVerDad.Metadatas;

import BaSeDeVerDad.Exceptions.NotValidDataException;

import java.util.ArrayList;
import java.util.List;

public class MetadatasAdministrator {

    List<Categoria> categories;

    public static void main(String[] args) throws Throwable {
        System.out.println("hola;");
    }

    public void CreateCategories(String[][] table){
        List<Categoria> categorias = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            int a = i;
            try{
                a = Integer.parseInt(table[i][0]);
            }catch (Exception e){
                System.out.println("a: " + a);
            }

            categorias.add(new Categoria(a, table[i][1], table[i][2]));
        }
        setCategories(categorias);

    }

    private void setCategories(List<Categoria> categories) {

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
    public User getUser(int client_number, String full_name, String username, String email, List<Card> cards){
        return new User(client_number, full_name, username, email, cards);
    }
}
