package repository;

import entity.Personnne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonneRepository extends Personnne {

    private Connection con;
    public PersonneRepository(){
        con = DBConnector.connect();
    }
    public void save(){
        try {
            String sql = "INSERT INTO personnes(nom,prenom,age) VALUES(?,?,?)";

            PreparedStatement stmtInsert = con.prepareStatement(sql);
            stmtInsert.setString(1,getNom());
            stmtInsert.setString(2,getPrenom());
            stmtInsert.setInt(3,getAge());
            stmtInsert.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
