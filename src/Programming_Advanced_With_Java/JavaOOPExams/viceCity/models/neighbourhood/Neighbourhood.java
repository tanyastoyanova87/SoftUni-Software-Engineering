package Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.neighbourhood;

import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
