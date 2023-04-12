import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Studentsql> italianStudent= new ArrayList<>();
        ArrayList<Studentsql> germanStudent= new ArrayList<>();
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "root";
            String password = "Gabri123!";


            conn = DriverManager.getConnection(DB_URL, USER, password);
            System.out.println("Connection successful");
            Statement stmt = conn.createStatement();
            //create a view italian_students that gets all the name and surname of the Italian students
            String sql1="CREATE OR REPLACE VIEW italian_student AS\nSELECT last_name,first_name\nFROM student\nWHERE country = 'Italy';";
            stmt.executeUpdate(sql1);

            String sql2="CREATE OR REPLACE VIEW german_student AS\nSELECT last_name,first_name\nFROM student\nWHERE country = 'Germany';";
            stmt.executeUpdate(sql2);

            String sql3="SELECT * FROM italian_student;";
            ResultSet rs = stmt.executeQuery(sql3);
            while(rs.next()) {
                String name=rs.getString("first_name");
                String surname=rs.getString("last_name");

                Studentsql st1= new Studentsql(name, surname);

                italianStudent.add(st1);
            }

            String sql4="SELECT * FROM german_student;";
            ResultSet rs2 = stmt.executeQuery(sql4);

            while(rs2.next()) {
                String name=rs2.getString("first_name");
                String surnname=rs2.getString("last_name");

                Studentsql st2= new Studentsql(name, surnname);

                germanStudent.add(st2);
            }




            stmt.close();
            conn.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Italian student:"+italianStudent);
        System.out.println("German student:"+germanStudent);
    }
}