package Programming_Advanced_With_Java.JavaOOPExams.handball.entities.gameplay;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment.Equipment;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipment;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.equipment = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int allProtection() {
        return this.equipment.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipment.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        this.teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipment;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s%n", getName(), this.getClass().getSimpleName()));
        sb.append("Team:");
        if (this.teams.isEmpty()) {
            sb.append(" none");
            sb.append(System.lineSeparator());
        } else {
            for (Team team : teams) {
                sb.append(" ").append(team.getName());
            }
            sb.append(System.lineSeparator());
        }
        sb.append(String.format("Equipment: %d, Protection: %d", this.equipment.size(), allProtection()));
        return sb.toString().trim();
    }
}
