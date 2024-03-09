package Programming_Advanced_With_Java.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        boolean removed = false;
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                this.players.remove(player);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new IllegalArgumentException(String.format("Programming_Advanced_With_Java.P05FootballTeamGenerator.Player %s is not in %s team.", name, getName()));
        }
    }

    public double getRating() {
        double sum = this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
        return  Math.round(sum / players.size());
    }
}
