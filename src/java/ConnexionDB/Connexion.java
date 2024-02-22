
package ConnexionDB;
import java.sql.*;

public class Connexion {
     private static Connection connex = null;
    static{
        try{
            Class.forName("org.postgresql.Driver");
            connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JSP", "postgres", "lionot");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static Connection getConn(){
        return connex;
    }
}
