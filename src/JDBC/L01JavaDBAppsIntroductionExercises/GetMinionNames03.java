package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMinionNames03 {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {

        getMinionsNames();

        connection.close();
    }

    private static void getMinionsNames() throws SQLException, IOException {
        int id = Integer.parseInt(bufferedReader.readLine());

        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT name FROM villains v WHERE v.id = ?");

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.printf("No villain with ID %s exists in the database.%n", id);
            return;
        }

        System.out.printf("Villain: %s%n", resultSet.getString("name"));

        preparedStatement = connection.prepareStatement(
                "SELECT m.name, m.age FROM minions m " +
                        "JOIN minions_villains mv ON mv.minion_id = m.id " +
                        "WHERE mv.villain_id = ?");

        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        int counter = 1;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n", counter++, resultSet.getString("name"),
                    resultSet.getInt("age"));
        }
    }
}
