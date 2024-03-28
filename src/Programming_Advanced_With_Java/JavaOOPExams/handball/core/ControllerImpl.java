package Programming_Advanced_With_Java.JavaOOPExams.handball.core;

import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment.ElbowPad;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment.Equipment;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.equipment.Kneepad;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.gameplay.Gameplay;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.gameplay.Indoor;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.gameplay.Outdoor;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.team.Bulgaria;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.team.Germany;
import Programming_Advanced_With_Java.JavaOOPExams.handball.entities.team.Team;
import Programming_Advanced_With_Java.JavaOOPExams.handball.repositories.EquipmentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static Programming_Advanced_With_Java.JavaOOPExams.handball.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private EquipmentRepository equipmentRepository;
    private Collection<Gameplay> gamePlays;

    public ControllerImpl() {
        this.equipmentRepository = new EquipmentRepository();
        this.gamePlays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType) {
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            default:
                throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }

        this.gamePlays.add(gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment;
        switch (equipmentType) {
            case "ElbowPad":
                equipment = new ElbowPad();
                break;
            case "Kneepad":
                equipment = new Kneepad();
                break;
            default:
                throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }

        this.equipmentRepository.add(equipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Gameplay gameplay = this.gamePlays.stream().filter(gameplays -> gameplays.getName().equals(gameplayName)).findFirst().orElse(null);

        Equipment equipment = this.equipmentRepository.findByType(equipmentType);
        if (equipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }

        assert gameplay != null;
        gameplay.addEquipment(equipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }

        Gameplay gameplay = this.gamePlays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        if (teamType.equals("Bulgaria") && Objects.requireNonNull(gameplay).getClass().getSimpleName().equals("Indoor")) {
            return GAMEPLAY_NOT_SUITABLE;
        } else {
            if (teamType.equals("Germany")) {
                assert gameplay != null;
                if (gameplay.getClass().getSimpleName().equals("Outdoor")) {
                    return GAMEPLAY_NOT_SUITABLE;
                }
            }
        }

        gameplay.addTeam(team);
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = this.gamePlays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        assert gameplay != null;
        gameplay.teamsInGameplay();
        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = this.gamePlays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        assert gameplay != null;
        int sumTeamAdvantages = gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, sumTeamAdvantages);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Gameplay gamePlay : this.gamePlays) {
            sb.append(gamePlay.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
