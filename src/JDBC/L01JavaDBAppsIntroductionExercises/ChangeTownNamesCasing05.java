package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing05 {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws SQLException, IOException {

        changeTownNamesToUpperCase();
        connection.close();
    }

    private static void changeTownNamesToUpperCase() throws IOException, SQLException {
        String country = bufferedReader.readLine();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE towns SET name = UPPER(name)" +
                    "WHERE country = ?");
        preparedStatement.setString(1, country);
        int count = preparedStatement.executeUpdate();

        if (count == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.printf("%d town names were affected.%n", count);
            preparedStatement = connection.prepareStatement(
                    "SELECT name FROM towns WHERE country = ? ");
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> townNames = new ArrayList<>();
            while (resultSet.next()) {
                townNames.add(resultSet.getString("name"));
            }
            System.out.println("[" + String.join(", ", townNames) + "]");
        }
    }
}
