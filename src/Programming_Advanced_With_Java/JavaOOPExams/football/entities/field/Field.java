package Programming_Advanced_With_Java.JavaOOPExams.football.entities.field;

import Programming_Advanced_With_Java.JavaOOPExams.football.entities.player.Player;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement.Supplement;

import java.util.Collection;

public interface Field {
    int sumEnergy();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void addSupplement(Supplement supplement);

    void drag();

    String getInfo() throws ClassNotFoundException;

    Collection<Player> getPlayers();

    Collection<Supplement> getSupplements();

    String getName();
}
