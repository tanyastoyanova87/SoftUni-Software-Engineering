package Programming_Advanced_With_Java.JavaOOPExams.spaceStation.core;

import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts.Astronaut;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts.Biologist;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts.Geodesist;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.astronauts.Meteorologist;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.mission.Mission;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.mission.MissionImpl;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.planets.Planet;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.models.planets.PlanetImpl;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.repositories.AstronautRepository;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.repositories.PlanetRepository;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.spaceStation.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }

        this.planetRepository.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        this.astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = this.planetRepository.findByName(planetName);
        List<Astronaut> astronauts = astronautRepository.getModels().stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());

        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(planet, astronauts);
        this.exploredPlanets++;
        long dead = astronauts.stream().filter(astronaut -> !astronaut.canBreath()).count();
        return String.format(PLANET_EXPLORED, planetName, dead);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets));
        sb.append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO);
        sb.append(System.lineSeparator());
        for (Astronaut model : this.astronautRepository.getModels()) {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, model.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen()));
            sb.append(System.lineSeparator());
            if (model.getBag().getItems().isEmpty()) {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none"));
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, model.getBag().getItems())));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
