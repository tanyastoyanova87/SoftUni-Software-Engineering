package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeStoredProcedure09 {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws SQLException, IOException {
        increaseMinionsAge();
        connection.close();
    }

    private static void increaseMinionsAge() throws IOException, SQLException {
        int id = Integer.parseInt(bufferedReader.readLine());

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, id);
        callableStatement.execute();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name, age FROM minions WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }
}
