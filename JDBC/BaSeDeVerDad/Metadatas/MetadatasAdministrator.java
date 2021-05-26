package BaSeDeVerDad.Metadatas;

import BaSeDeVerDad.Exceptions.NotValidDataException;

public class MetadatasAdministrator {

    public static void main(String[] args) throws Throwable {
        try {
            Date a = getDate("56/6/4 1:4:381");
            System.out.println(a.toString());
        }catch(NotValidDataException nvde){
            System.out.println(" mesagge: " + nvde.getMessage());

        }
        catch (Exception e){
            System.out.println(" mesage: " + e.getMessage());
        }

    }

    public static Date getDate(String date){
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
}
