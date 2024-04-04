package Programming_Advanced_With_Java.JavaOOPExams.climbers.core;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber.Climber;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber.RockClimber;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climber.WallClimber;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climbing.Climbing;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.climbing.ClimbingImpl;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.mountain.Mountain;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.models.mountain.MountainImpl;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.repositories.ClimberRepository;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.repositories.MountainRepository;

import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.climbers.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ClimberRepository climberRepository;
    private MountainRepository mountainRepository;
    private int climbed;

    public ControllerImpl() {
        this.climberRepository = new ClimberRepository();
        this.mountainRepository = new MountainRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type) {
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default:
                throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        }

        this.climberRepository.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        this.mountainRepository.add(mountain);
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = this.climberRepository.byName(climberName);
        if (climber == null) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }

        this.climberRepository.remove(climber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Mountain mountain = this.mountainRepository.byName(mountainName);
        if (this.climberRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climberRepository.getCollection());
        this.climbed++;

        int removedClimbers = climberRepository.getCollection().stream().filter(climber -> !climber.canClimb()).collect(Collectors.toList()).size();
        return String.format(PEAK_CLIMBING, mountainName, removedClimbers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_MOUNTAIN_COUNT, climbed));
        sb.append(System.lineSeparator());
        sb.append(FINAL_CLIMBERS_STATISTICS);
        sb.append(System.lineSeparator());
        for (Climber climber : this.climberRepository.getCollection()) {
            sb.append(String.format(FINAL_CLIMBER_NAME, climber.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            sb.append(System.lineSeparator());
            sb.append("Conquered peaks: ");
            if (climber.getRoster().getPeaks().isEmpty()) {
                sb.append("None");
                sb.append(System.lineSeparator());
            } else {
                String join = String.join(", ", climber.getRoster().getPeaks());
                sb.append(join);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
