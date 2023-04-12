import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> surname=new ArrayList<>();
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "root";
            String password = "Gabri123!";



            conn = DriverManager.getConnection(DB_URL, USER, password);
            System.out.println("Connection successful");
            Statement stmt = conn.createStatement();

            System.out.println("Contents of the first record: ");
            stmt.executeUpdate(CREATE_TABLE_SQL);
            stmt.executeUpdate(INSERT_DATA_SQL);

            String query = "Select * from student";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            System.out.print("Name: "+rs.getString("last_Name")+", ");
            surname.add(rs.getString("first_Name"));

            rs.next();
            System.out.print("Name: "+rs.getString("last_Name")+", ");
            surname.add(rs.getString("first_Name"));

            rs.next();
            System.out.print("Name: "+rs.getString("last_Name")+", ");
            surname.add(rs.getString("first_Name"));

            rs.next();
            System.out.print("Name: "+rs.getString("last_Name")+". ");
            surname.add(rs.getString("first_Name"));




            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("All the surnames: " + surname);
    }
    static String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS student (" +
            "student_id INT(10) NOT NULL AUTO_INCREMENT, " +
            "last_name VARCHAR(30) NULL," +
            "first_name VARCHAR(30) NULL," +
            "PRIMARY KEY (student_id))";
    static String INSERT_DATA_SQL = "INSERT INTO student  (last_name, first_name) VALUES" +
            "('Gabriele', 'Castiglione'), " +
            "('Samuele', 'Castiglione'), " +
            "('Mario', 'Rossi'), " +
            "('Luigi', 'Verdi')";
}
