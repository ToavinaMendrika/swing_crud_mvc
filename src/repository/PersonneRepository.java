package repository;

import entity.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonneRepository extends Personne {

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

    public  String[][] findAll(){
        ResultSet rs = null;
        try{
            String sql = "SELECT nom,prenom,age FROM personnes";
            PreparedStatement stmtSelect = con.prepareStatement(sql);
            rs = stmtSelect.executeQuery(sql);
            int i = 0;
            int size =0;
            if (rs != null)
            {
                rs.last();    // moves cursor to the last row
                size = rs.getRow(); // get row id
            }
            String[][] lists = new String[size][3];
            rs.first();
            String fnom = rs.getString("nom");
            String fprenom = rs.getString("prenom");
            String fage = rs.getString("age");
            lists[i][0] = fnom;
            lists[i][1] = fprenom;
            lists[i][2] = fage;
            i++;
            while(rs.next())
            {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String age = rs.getString("age");
                lists[i][0] = nom;
                lists[i][1] = prenom;
                lists[i][2] = age;
                i++;
            }
            return lists;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new String[0][0];

    }

    public String[] show(int id){
        ResultSet rs = null;
        String[] result = new String[3];
        try{
            String sql = "SELECT nom,prenom,age FROM personnes WHERE id=?";
            PreparedStatement stmtSelect = con.prepareStatement(sql);
            stmtSelect.setInt(1,id);
            rs = stmtSelect.executeQuery();
            rs.first();
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String age = rs.getString("age");
            result = new String[]{nom, prenom, age};
        }catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }

    public Integer[] findIds(){
        ResultSet rs = null;

        try{
            String sql = "SELECT id FROM personnes";
            PreparedStatement stmtSelect = con.prepareStatement(sql);
            rs = stmtSelect.executeQuery(sql);
            int i = 0;
            int size =0;
            if (rs != null)
            {
                rs.last();    // moves cursor to the last row
                size = rs.getRow(); // get row id
            }
            Integer[] lists = new Integer[size];
            rs.first();
            Integer fid = rs.getInt("id");
            lists[i] = fid;
            i++;
            while(rs.next())
            {
                Integer id = rs.getInt("id");
                lists[i] = id;
                i++;
            }
            return lists;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new Integer[0];
    }

    public void update(int id){
        try {
            String sql = "UPDATE  personnes SET nom=?, prenom=?, age=? WHERE id=?";

            PreparedStatement stmtInsert = con.prepareStatement(sql);
            stmtInsert.setString(1,getNom());
            stmtInsert.setString(2,getPrenom());
            stmtInsert.setInt(3,getAge());
            stmtInsert.setInt(4,id);
            stmtInsert.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
