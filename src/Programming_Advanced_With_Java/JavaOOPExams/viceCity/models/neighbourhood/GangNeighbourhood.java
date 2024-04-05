package Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.neighbourhood;

import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns.Gun;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            for (Player civilPlayer : civilPlayers) {
                while (gun.canFire() && civilPlayer.isAlive()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
            }
        }
        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                while (gun.canFire() && mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints(gun.fire());
                }
            }
        }
    }
}
