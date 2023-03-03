package home_work_3_2.Server;

import java.sql.*;

public class SQLArchive {


    private static Connection connection;
    private static Statement stmt;

    public SQLArchive() {
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BRABUS\\IdeaProjects\\Damir\\src\\home_work_3_2\\Server\\archive.db");
            System.out.println("Подключились к архиву");
            stmt = connection.createStatement();
        } catch (Exception var1) {
            var1.getStackTrace();
            System.out.println("Не подключились");
        }

    }

    public static void createTableEx() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS archive (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " text TEXT\n" +
                " );");
    }


//    public static void insertEx(String text1) throws SQLException {
//        System.out.println(text1);
//        stmt.executeUpdate("INSERT INTO archive (text) VALUES (text1);");
//    }


    public static void insertEx(String text1) throws SQLException {

        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO archive (text) VALUES (?)")) {
            prepInsert.setString(1, text1);
            prepInsert.addBatch();
            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String readEx() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM archive;")) {
            String fullText = "";
            while (rs.next()) {
                fullText += (rs.getString("text") + " \n");
            }
            return fullText;
        }
    }


    public static void dropTableEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS archive;");
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

}
