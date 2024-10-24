package JDBC.L01JavaDBAppsIntroductionExercises;

import JDBC.L01JavaDBAppsIntroductionLab.DBConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMinion04 {
    private static final Connection connection = DBConnection.getConnection();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {
        String[] minionInfo = bufferedReader.readLine().split("\\s+");
        String[] villainInfo = bufferedReader.readLine().split("\\s+");

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionsTown = minionInfo[3];

        int townId = checkIfTownIsPresent(minionsTown);
        if (townId == 0) {
            townId = createTown(minionsTown);
        }

        int minionId = createMinion(minionName, minionAge, townId);
        
        String villainName = villainInfo[1];
        int villainId = checkIfVillainIsPresent(villainName);
        if (villainId == 0) {
            villainId = createVillain(villainName);
        }

        assignMinionToVillain(minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
        connection.close();
    }

    private static void assignMinionToVillain(int minionId, int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO minions_villains VALUE (?, ?)");
        preparedStatement.setInt(1, minionId);
        preparedStatement.setInt(2, villainId);
        preparedStatement.executeUpdate();

    }

    private static int createVillain(String villainName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO villains (name, evilness_factor) " +
                        "VALUES (?, 'evil')");
        preparedStatement.setString(1, villainName);
        preparedStatement.executeUpdate();
        System.out.printf("Villain %s was added to the database.%n", villainName);

        preparedStatement = connection.prepareStatement(
                "SELECT id FROM villains WHERE name = ?");
        preparedStatement.setString(1, villainName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        return 0;
    }

    private static int createMinion(String minionName, int minionAge, int townId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?)");
        preparedStatement.setString(1, minionName);
        preparedStatement.setInt(2, minionAge);
        preparedStatement.setInt(3, townId);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement(
                "SELECT id FROM minions WHERE name = ?");
        preparedStatement.setString(1, minionName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }

    private static int checkIfVillainIsPresent(String villain) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM villains " +
                        "WHERE name = ?");
        preparedStatement.setString(1, villain);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
           return resultSet.getInt("id");
        }
        return 0;
    }

    private static int createTown(String minionsTown) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO towns (name) " +
                        "VALUES (?)");
        preparedStatement.setString(1, minionsTown);
        preparedStatement.executeUpdate();
        System.out.printf("Town %s was added to the database.%n", minionsTown);

        preparedStatement = connection.prepareStatement(
                "SELECT id FROM towns WHERE name = ?");
        preparedStatement.setString(1, minionsTown);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }

    private static int checkIfTownIsPresent(String minionsTown) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT id FROM towns " +
                        "WHERE name = ?");
        preparedStatement.setString(1, minionsTown);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        return 0;
    }
}
