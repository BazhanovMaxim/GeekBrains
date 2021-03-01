package NetworkChat.DataBase;

import NetworkChat.client.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseAuthService {

    /**
     * Запрос на поиск пользователя по логину и паролю
     *
     * @param userLogin    логин пользователя
     * @param userPassword пароль пользователя
     * @return boolean запроса
     */
    public Record findUserByLoginAndPassword(String userLogin, String userPassword) {
        Connection connection = DBService.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM clients WHERE login = '" + userLogin + "' and password = '" + userPassword + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new Record(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Запрос в БД на создание пользователя
     *
     * @param userName     имя пользователя
     * @param userLogin    логин пользователя
     * @param userPassword пароль пользователя
     * @return boolean запроса
     */
    public boolean userRegistration(String userName, String userLogin, String userPassword) {
        try (Connection connection = DBService.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO clients (name, login, password) VALUES (?, ?, ?)");
            statement.setString(1, userName);
            statement.setString(2, userLogin);
            statement.setString(3, userPassword);
            return statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
