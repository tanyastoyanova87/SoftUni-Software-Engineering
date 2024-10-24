package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

public class PrintAllMinionNames07 {
    private static final Connection connection = DBConnection.getConnection();
    public static void main(String[] args) throws SQLException {

        printMinionNames();
        connection.close();
    }

    private static void printMinionNames() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();
        Deque<String> names = new ArrayDeque<>();
        while (resultSet.next()) {
            names.add(resultSet.getString("name"));
        }
        while (!names.isEmpty()) {
            System.out.println(names.pollFirst());
            System.out.println(names.pollLast());
        }
    }
}
