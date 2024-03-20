package Programming_Advanced_With_Java.JavaOOPExams.football.core;


import Programming_Advanced_With_Java.JavaOOPExams.football.entities.field.ArtificialTurf;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.field.Field;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.field.NaturalGrass;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.player.Men;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.player.Player;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.player.Women;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement.Liquid;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement.Powdered;
import Programming_Advanced_With_Java.JavaOOPExams.football.entities.supplement.Supplement;
import Programming_Advanced_With_Java.JavaOOPExams.football.repositories.SupplementRepository;
import Programming_Advanced_With_Java.JavaOOPExams.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static Programming_Advanced_With_Java.JavaOOPExams.football.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplementRepository;
    private Collection<Field> fieldCollection;

    public ControllerImpl() {
        this.supplementRepository = new SupplementRepositoryImpl();
        this.fieldCollection = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        this.fieldCollection.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplementRepository.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = supplementRepository.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        for (Field field : this.fieldCollection) {
            if (field.getName().equals(fieldName)) {
                field.addSupplement(supplement);
                this.supplementRepository.remove(supplement);
            }
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        for (Field field : this.fieldCollection) {
            if (field.getName().equals(fieldName)) {
                if (playerType.equals("Men") && field.getName().equals("ArtificialTurf")) {
                    return FIELD_NOT_SUITABLE;
                } else if (playerName.equals("Women") && field.getName().equals("NaturalGrass")) {
                    return FIELD_NOT_SUITABLE;
                } else {
                    field.addPlayer(player);
                }
            }
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Collection<Player> players = new ArrayList<>();
        for (Field field : this.fieldCollection) {
            if (field.getName().equals(fieldName)) {
                field.drag();
                players = field.getPlayers();
            }
        }
        return String.format(PLAYER_DRAG, players.size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        int sumStrength = 0;
        for (Field field : this.fieldCollection) {
            if (field.getName().equals(fieldName)) {
                sumStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
            }
        }
        return String.format(STRENGTH_FIELD, fieldName, sumStrength);
    }

    @Override
    public String getStatistics() throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        for (Field field : this.fieldCollection) {
            sb.append(field.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
