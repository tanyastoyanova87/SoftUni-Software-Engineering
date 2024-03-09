package Programming_Advanced_With_Java.L02OOPEncapsulationLab.P04FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private final List<Person> firstTeam;
    private final List<Person> reserveTeam;

    public Team(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

    public Team(String name, List<Person> firstTeam, List<Person> reserveTeam) {
        this.name = name;
        this.firstTeam = firstTeam;
        this.reserveTeam = reserveTeam;
    }

    public String getName() {
        return name;
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeam.add(player);
        } else {
            this.reserveTeam.add(player);
        }
    }
}
