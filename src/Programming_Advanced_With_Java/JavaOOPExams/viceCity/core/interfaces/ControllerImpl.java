package Programming_Advanced_With_Java.JavaOOPExams.viceCity.core.interfaces;

import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns.Gun;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns.Pistol;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.guns.Rifle;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.neighbourhood.GangNeighbourhood;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.neighbourhood.Neighbourhood;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players.CivilPlayer;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players.MainPlayer;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Deque<Gun> guns;
    private Collection<Player> players;

    public ControllerImpl() {
        guns = new ArrayDeque<>();
        this.players = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.players.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }

        this.guns.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Player player = null;
        Gun gun = null;
        if (this.guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        } else {
            gun = guns.iterator().next();
        }

        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(gun);
            this.guns.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        } else {
            for (Player civilPlayer : this.players) {
                if (civilPlayer.getName().equals(name)) {
                    player = civilPlayer;
                    player.getGunRepository().add(gun);
                    this.guns.remove(gun);
                    break;
                }
            }
            if (player == null) {
                return CIVIL_PLAYER_DOES_NOT_EXIST;
            }
        }

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
    }

    @Override
    public String fight() {
        StringBuilder sb = new StringBuilder();
        Neighbourhood neighbourhood = new GangNeighbourhood();
        neighbourhood.action(mainPlayer, players);
        boolean isEverythingOk = true;
        for (Player civilPlayer : this.players) {
            if (civilPlayer.getLifePoints() < 50) {
                isEverythingOk = false;
                break;
            }
        }

        List<Player> deadPlayers = this.players.stream().filter(player -> !player.isAlive()).collect(Collectors.toList());
        List<Player> alivePlayers = this.players.stream().filter(Player::isAlive).collect(Collectors.toList());
        this.players.removeAll(deadPlayers);

        if (mainPlayer.getLifePoints() == 100 && isEverythingOk) {
            return FIGHT_HOT_HAPPENED;
        }

        sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, alivePlayers.size()));
        sb.append(System.lineSeparator());

        return sb.toString().trim();
    }
}
