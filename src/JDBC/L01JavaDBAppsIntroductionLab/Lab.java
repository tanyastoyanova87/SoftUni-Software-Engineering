package JDBC.L01JavaDBAppsIntroductionLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Lab {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {
        getUserInfo();

        connection.close();
    }

    private static void getUserInfo() throws SQLException, IOException {
        String username = bufferedReader.readLine();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT COUNT(game_id) AS count, user_name, first_name, last_name " +
                        "FROM users_games ug " +
                        "JOIN users u ON ug.user_id = u.id " +
                        "WHERE u.user_name = ? " +
                        "GROUP BY ug.user_id");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("No such user exists");
            return;
        }

        System.out.printf("User: %s%n", resultSet.getString("user_name"));
        System.out.printf("%s %s has played %d games%n", resultSet.getString("first_name"),
                resultSet.getString("last_name"), resultSet.getInt("count"));
    }
}