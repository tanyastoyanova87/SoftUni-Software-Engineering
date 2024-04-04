package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.core;

import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers.AnimalExplorer;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers.Explorer;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers.GlacierExplorer;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers.NaturalExplorer;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.mission.Mission;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.mission.MissionImpl;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.states.State;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.states.StateImpl;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.repositories.ExplorerRepository;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.repositories.Repository;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        this.explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        this.stateRepository.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        this.explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = this.stateRepository.byName(stateName);
        List<Explorer> explorers = this.explorerRepository.getCollection()
                .stream().filter(explorer -> explorer.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(state, explorers);

        this.exploredStates++;
        long retired = explorers.stream().filter(Explorer::canSearch).count();
        return String.format(STATE_EXPLORER, stateName, explorers.size() - retired);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED, this.exploredStates));
        sb.append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            sb.append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
