package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
public class DBConnector {

    public static Connection connection;

    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/personne_swg","root","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
