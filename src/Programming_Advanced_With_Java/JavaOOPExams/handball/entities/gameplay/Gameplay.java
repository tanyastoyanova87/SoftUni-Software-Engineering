package Programming_Advanced_With_Java.JavaOOPExams.handball.entities.gameplay;

import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.team.Team;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment.Equipment;

import java.util.Collection;

public interface Gameplay {
    int allProtection();

    void addTeam(Team team);

    void removeTeam(Team team);

    void addEquipment(Equipment equipment);

    void teamsInGameplay();

    Collection<Team> getTeam();

    Collection<Equipment> getEquipments();

    String getName();


}
