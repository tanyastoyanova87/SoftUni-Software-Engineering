package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class IncreaseMinionsAge08 {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, SQLException {


        increaseMinionsAge();
    }

    private static void increaseMinionsAge() throws SQLException, IOException {
        int[] ids = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < ids.length; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE minions SET age = age + 1, " +
                            "name = LOWER(name) " +
                            "WHERE id = ?");
            preparedStatement.setInt(1, ids[i]);
            preparedStatement.executeUpdate();
        }

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name, age FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }
}
