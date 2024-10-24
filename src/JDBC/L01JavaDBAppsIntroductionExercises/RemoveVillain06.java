package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveVillain06 {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws SQLException, IOException {
        removeVillain();
        connection.close();
    }

    private static void removeVillain() throws IOException, SQLException {
        int id = Integer.parseInt(reader.readLine());

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT name FROM villains v WHERE v.id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("No such villain was found");
        } else {
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM minions_villains mv " +
                            "WHERE mv.villain_id = ?");
            preparedStatement.setInt(1, id);
            int countDeletedMinions = preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(
                    "DELETE FROM villains v " +
                            "WHERE v.id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.printf("%s was deleted%n", resultSet.getString("name"));
            System.out.printf("%d minions released%n", countDeletedMinions);
        }
    }
}
