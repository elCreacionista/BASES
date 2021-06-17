package ExamenBD;


import com.mysql.cj.protocol.Resultset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
* Escriu un programa fet en JAVA + JDBC que implementi els següents requeriments. S’ha d’implementar seguint el patró de disseny DAO
Connectar-se a la BD examen_jdbc amb l’usuari/password creats a l’exercici 3 (es valorarà que la connexió agafi els paràmetres a
partir d’un fitxer de configuració db.properties )
El programa ha de ser capaç d’insertar les següents dades de la taula post:
+----+-----------+----------------------------------------------------------+-----------+----------+------------+-------+------------+
| id | author_id | title                                                    | summary   | content  | created    | likes | published  |
+----+-----------+----------------------------------------------------------+-----------+----------+------------+-------+------------+
|  1 |         3 | The Calculus of Inductive Constructions                  | Summary 1 | Content1 | 2021-01-01 |   100 | 2021-04-01 |
|  2 |         2 | Database Systems: Design, Implementation, and Management | Summary2  | Content2 | 2018-01-01 |   200 | 2021-05-01 |
|  3 |         2 | The Road Ahead                                           | Summary3  | Content3 | 2017-01-01 |   250 | 2020-05-01 |
+----+-----------+----------------------------------------------------------+-----------+----------+------------+-------+------------+
El programa ha de ser capaç de fer una cerca dels registres de la taula post segons id, i/o id autor, i/o títol, ordenats pel títol
El programa ha de ser capaç de carregar un determinat post (per exemple id 1)  i mostrar les seves dades per pantalla.
El programa ha de ser capaç d’afegir un like (augmentar +1 la columna likes) a un post.
*/
public class Conector {
    public String namedatabase = "examen_jdbc";
    String myDriver= "com.mysql.cj.jdbc.Driver";
    String myUrl= "jdbc:mysql://localhost:3306/" + namedatabase;
    Connection conn;
    Statement st;
    ResultSet rs;
    String user, password;
/*c.insertarDades("pep", new String[][]{{"ola", "don", "pepito", "hola", "don", "jose"},
                                                    {"paso", "por", "su", "casa"},
                                                    {"por", "su", "casa", "yo", "pase"}});

        c.veureTaula("user", new String[]{"id", "firstName", "lastName"}, "id", true);
        c.veureColumna("user", new String[]{"id", "firstName", "lastName"}, new String[]{"id","4"});
        c.updateTaula("pep",  new String[][]{{"ola", "don"}, {"paso", "por"}, {"por", "su"}}, new String[]{"ola", "ola"});
*/
    public static void main(String[] args) throws Exception {
        Conector c = new Conector();
        System.out.println("EX1");

        //c.insertarDades("post", new String[]{"1", "3", "'The Calculus of Inductive'" , "'Summary 1'", "'Content1'", "'2021-01-01'", "100","'2021-04-01'"});
        //c.insertarDades("post", new String[]{"2","2","'Database Systems: Design, Implementation, and Management'","'Summary2'","'Content2'","'2018-01-01'","200","'2021-05-01'"});
        //c.insertarDades("post", new String[]{"3","2","'The Road'","'Summary3'","'Content3'","'2017-01-01'","250","'2020-05-01'"});
        System.out.println("EX2");

        c.veureTaula("post", new String[]{"id","author_id","title","summary","content","created","likes","published"},"title", true);
        System.out.println("EX3");

        c.veureColumna("post",new String[]{"id","author_id","title","summary","content","created","likes","published"},new String[]{"id", "1"});
        System.out.println("EX4");
        c.updateTaula("post", new String[][]{{"id","author_id","title","summary","content","created","likes","published"}, {"1", "3", "'The Calculus of Inductive'" , "'Summary 1'", "'Content1'", "'2021-01-01'", "100","'2021-04-01'"}},new String[]{"id","1"});

        c.Desconectar();
    }


    public void updateTaula(String taula, String[][] dades, String[] condicio) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(taula).append(" SET ");
        for (int j = 0; j < dades[0].length; j++) {
            sb.append(dades[0][j]).append(" = ").append(dades[1][j]);
            if (j < dades[0].length - 1){
                sb.append(", ");
            }
        }
        sb.append(" WHERE ").append(condicio[0]).append(" = ").append(condicio[1]);
        sb.append(";");
        System.out.println(sb.toString());
        st = conn.createStatement();
        st.executeUpdate(sb.toString());

    }
    private void veureTaula(String taula, String[] columnes, String prioritat, boolean ascend) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for (int i = 0; i < columnes.length; i++) {
            sb.append(columnes[i]);
            if (i < columnes.length - 1)
                sb.append(", ");
        }
        sb.append(" FROM ").append(taula);
        if (!prioritat.equals("")) {
            sb.append(" ORDER BY ").append(prioritat);
            if (ascend)
                sb.append(" ASC;");
            else
                sb.append(" DESC;");
        }
        st = conn.createStatement();
        rs = st.executeQuery(sb.toString());
        System.out.println(sb.toString());
        int i = 0;
        while (rs.next()){
            System.out.println(columnes[i] + " --> " + rs.getString(columnes[i]));
            i++;
        }
    }
    private void veureColumna(String taula, String[] columnes, String[] filtratge) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for (int i = 0; i < columnes.length; i++) {
            sb.append(columnes[i]);
            if (i < columnes.length - 1)
                sb.append(", ");
        }
        sb.append(" FROM ").append(taula).append(" WHERE ");
        sb.append(filtratge[0]).append(" = ").append(filtratge[1]).append(";");

        st = conn.createStatement();
        rs = st.executeQuery(sb.toString());
        System.out.println(sb.toString());
        int i = 0;
        while (rs.next()){
            System.out.println(columnes[i] + " --> " + rs.getString(columnes[i]));
            i++;
        }
    }

    public void insertarDades(String taula, String[] dades) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT into ").append(taula).append(" values( ");
        for (int i = 0; i < dades.length; i++) {
            sb.append(dades[i]);
            if (i < dades.length - 1){
                sb.append(", ");
            }
        }
            sb.append(");");
        String query = sb.toString();
        System.out.println(query);
        st = conn.createStatement();
        st.executeUpdate(query);
    }
    private void setUserPassword(){
        try {
            InputStream is = new FileInputStream("ExamenBD/db/properties");
            byte[] b = is.readAllBytes();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                char c =(char) b[i];
                sb.append(c);
                System.out.println(c);
            }
            String[] data = sb.toString().split("/");
            this.user = data[0];
            this.password = data[1];
        } catch (IOException e) {
            this.user = "root";
            this.password = "password";
            System.out.println("Error al llegir l'arxiu, conectant amb root... ");
        }
    }

    public Conector(){
        setUserPassword();
        try {
            CrearConexion();

        }catch(Exception c) {
            System.out.println("Oops! " + c.getMessage());
        }
    }
    public void CrearConexion() throws Exception {
        Class.forName(myDriver);
        conn = DriverManager.getConnection(myUrl, this.user, this.password);
        System.out.println("Conectant amb la base de dades");
    }
    public void Desconectar() throws SQLException {

        if (conn != null)
            conn.close();
        if (st != null)
            st.close();
        if (rs != null)
            rs.close();
        System.out.println("Tancant la conexió amb la base de dades");
    }

}
