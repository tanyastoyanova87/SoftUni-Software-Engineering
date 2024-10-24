package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetVillainsNames02 {

    private static final Connection connection = DBConnection.getConnection();
    public static void main(String[] args) throws SQLException {

        getVillainsNamesAndCount();

        connection.close();
    }
    private static void getVillainsNamesAndCount() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT name, COUNT(mv.villain_id) AS count FROM villains v " +
                        "JOIN minions_villains mv ON v.id = mv.villain_id " +
                        "GROUP BY name, mv.villain_id " +
                        "HAVING COUNT > 15 " +
                        "ORDER BY count DESC");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") +
                    " " + resultSet.getInt("count"));
        }
    }
}
