import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Main {

            public static void main(String[] args) {
                Connection conn = null;
                try {
                    String DB_URL = "jdbc:mysql://localhost:3306/newdb";
                    String USER = "root";
                    String password = "Gabri123!";

                    conn = DriverManager.getConnection(DB_URL, USER, password);
                    System.out.println("Connection successful");
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(CREATE_TABLE_SQL);
                    stmt.executeUpdate(INSERT_DATA_SQL);
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
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

