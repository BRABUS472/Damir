package home_work_3_2.Server;

import java.sql.*;

public class SQLHandler1 {

    private static Connection connection;
    private static Statement stmt;
    private static final String CONN_STRING = "C:\\Users\\BRABUS\\IdeaProjects\\Damir\\src\\home_work_3_2\\Server\\database.db";

    public SQLHandler1() {
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\BRABUS\\IdeaProjects\\Damir\\src\\home_work_3_2\\Server\\database.db");
            System.out.println("Подключились");
            stmt = connection.createStatement();
        } catch (Exception var1) {
            var1.getStackTrace();
            System.out.println("Не подключились");
        }
    }

    public static String getNickByLogPass(String login, String password) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname FROM users WHERE login='" + login + "' AND password='" + password + "';");
            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException var3) {
            var3.getStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (Exception var1) {
            var1.getStackTrace();
        }
    }
}