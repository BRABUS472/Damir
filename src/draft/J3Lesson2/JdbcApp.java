package draft.J3Lesson2;

import java.sql.*;

public class JdbcApp {

    private static Connection connection;
    private static Statement stmt;
    private static final String CONN_STRING = "C:\\Users\\BRABUS\\IdeaProjects\\Damir\\src\\draft\\J3Lesson2\\demobase.db";

    public static void main(String[] args) {
        try {
            connect();
            //createTableEx();
            //insertEx();
            readEx();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не подключились");
        } finally {
           disconnect();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BRABUS\\IdeaProjects\\Damir\\src\\draft\\J3Lesson2\\demobase.db");
            System.out.println("Подключились");
        stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        }


    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void createTableEx() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Students1 (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " name TEXT,\n" +
                " score INTEGER\n" +
                " );");
    }
    private static void dropTableEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS Students1;");
    }


    private static void readEx() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM Students;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                        rs.getInt(3));
            }
        }
    }
    private static void clearTableEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students1;");
    }
    private static void deleteEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM students1 WHERE name = 'Bob1';");

    }
    private static void updateEx() throws SQLException {
        stmt.executeUpdate("UPDATE students1 SET score = 100 WHERE name = 'Bob4';");
    }
    private static void insertEx() throws SQLException {
        stmt.executeUpdate("INSERT INTO students1 (name, score) VALUES ('Bob4', 60);");
    }

}