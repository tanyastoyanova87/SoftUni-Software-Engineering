package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.core;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diver.*;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diving.Diving;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.diving.DivingImpl;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.divingSite.DivingSite;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.divingSite.DivingSiteImpl;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.repositories.DiverRepository;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.repositories.DivingSiteRepository;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private int countSites;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        switch (kind) {
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException(DIVER_INVALID_KIND);

        }
        this.diverRepository.add(diver);
        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String seaCreature : seaCreatures) {
            divingSite.getSeaCreatures().add(seaCreature);
        }
        divingSiteRepository.add(divingSite);
        return String.format(DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = this.diverRepository.byName(diverName);
        if (diver == null) {
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }
        this.diverRepository.remove(diver);
        return String.format(DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> suitableDivers = this.diverRepository.getCollection()
                .stream().filter(diver -> diver.getOxygen() > 30)
                .collect(Collectors.toList());
        if (suitableDivers.isEmpty()) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }

        Diving diving = new DivingImpl();
        DivingSite divingSite = this.divingSiteRepository.byName(siteName);

        diving.searching(divingSite, suitableDivers);
        countSites++;

        List<Diver> removedDivers = this.diverRepository.getCollection()
                .stream().filter(diver -> diver.getOxygen() < 30)
                .collect(Collectors.toList());

        return String.format(SITE_DIVING, siteName, removedDivers.size());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The dive took place at %d site/s.%n", this.countSites));
        sb.append("Diver's statistics:").append(System.lineSeparator());
        for (Diver diver : diverRepository.getCollection()) {
            sb.append(String.format("Name: %s%n", diver.getName()));
            sb.append(String.format("Oxygen: %.0f%n", diver.getOxygen()));
            if (diver.getSeaCatch().getSeaCreatures().isEmpty()) {
                sb.append("Diver's catch: None").append(System.lineSeparator());
            } else {
                sb.append(String.format("Diver's catch: %s", String.join(", ", diver.getSeaCatch().getSeaCreatures())));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
