package NetworkChat.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static final String PASSWORD = "";
    private static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/myapp?useUnicode=yes&serverTimezone=UTC";
    private static final String USER = "root";

    static {
        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получаем подключение
     *
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throw new RuntimeException("Connection getting error");
        }
    }
}
