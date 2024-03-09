package Programming_Advanced_With_Java.JavaAdvancedExams.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                return this.roster.remove(player);
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removed = new ArrayList<>();
        for (Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                removed.add(player);
            }
        }
        this.roster.removeAll(removed);
        Player[] players = new Player[removed.size()];
        for (int i = 0; i < removed.size(); i++) {
            players[i] = removed.get(i);
        }
        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:%n", this.name));
        for (Player player : this.roster) {
            sb.append(String.format("%s%n", player));
        }
        return sb.toString();
    }
}
