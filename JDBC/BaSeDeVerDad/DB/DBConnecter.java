package BaSeDeVerDad.DB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnecter {


    public String namedatabase = "limbo";
    String myDriver= "com.mysql.cj.jdbc.Driver";
    String myUrl= "jdbc:mysql://localhost:3306/" + namedatabase;
    Connection conn;
    Statement st;
    ResultSet rs;
    DBConnecter(){
        try {
            Connect();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void Connect() throws Exception {
        Class.forName(myDriver);
        conn = DriverManager.getConnection(myUrl, "root", "password");
        System.out.println("Conectando con la base");
    }
    public void Disconnect() throws SQLException {

        if (conn != null)
            conn.close();
        if (st != null)
            st.close();
        if (rs != null)
            rs.close();
        System.out.println("cerrando conexion");
    }


    /*****************************************       CONSULTES         ****************************************/
    public String[] getRow(String query, String columns) throws Exception {

        List<String> data = new ArrayList<>();
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()){
            data.add(rs.getString(columns));
        }
        return data.toArray(new String[0]);
    }


    public String[][] getTable(String query, String[] latabla) throws Exception {

        st = conn.createStatement();
        rs = st.executeQuery(query);
        int nfilas = 0;
        int i = 0;

        while (rs.next()){
            nfilas ++;
        }

        String[][] respuestas = new String[nfilas][latabla.length];

        rs = st.executeQuery(query);
        while (rs.next()){

            for (int j = 0; j <latabla.length ; j++) {

                respuestas[i][j] = rs.getString(latabla[j]);
            }
            i++;
        }

        return respuestas;
    }
    /*****************************************       INSERTS         ****************************************/

    protected boolean Insert(String table, String values)  {
        try {
            String query = "insert into " + table + " values (" + values + ");";
            st = conn.createStatement();
            rs = st.executeQuery(query);
        }catch (java.sql.SQLException sqle){
            System.out.println(sqle.getMessage());
            return false;
        }

        return true;
    }
    /*****************************************       UPDATES         ****************************************/
    /*****************************************       DELETES         ****************************************/

}