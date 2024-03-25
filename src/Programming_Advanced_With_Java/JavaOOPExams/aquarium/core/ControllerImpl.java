package Programming_Advanced_With_Java.JavaOOPExams.aquarium.core;

import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.aquariums.Aquarium;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.aquariums.FreshwaterAquarium;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.aquariums.SaltwaterAquarium;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.decorations.Decoration;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.decorations.Ornament;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.decorations.Plant;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.fish.Fish;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.fish.FreshwaterFish;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.fish.SaltwaterFish;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static Programming_Advanced_With_Java.JavaOOPExams.aquarium.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }

        this.decorationRepository.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorationRepository.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
            }
        }

        this.decorationRepository.remove(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.stream()
                .filter(aquariums -> aquariums.getName().equals(aquariumName))
                .findFirst().orElse(null);

        if (fishType.equals("FreshwaterFish") && Objects.requireNonNull(aquarium).getClass().getSimpleName().equals("SaltwaterAquarium")) {
            return WATER_NOT_SUITABLE;
        } else if (fishType.equals("SaltwaterFish") && Objects.requireNonNull(aquarium).getClass().getSimpleName().equals("FreshwaterAquarium")) {
            return WATER_NOT_SUITABLE;
        }

        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream()
                .filter(aquariums -> aquariums.getName().equals(aquariumName))
                .findFirst().orElse(null);


        if (aquarium != null) {
            aquarium.feed();
        }

        assert aquarium != null;
        return String.format(FISH_FED, aquarium.getFish().size());

    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream()
                .filter(aquariums -> aquariums.getName().equals(aquariumName))
                .findFirst().orElse(null);

        assert aquarium != null;
        double fishPriceSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationsPriceSum = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(VALUE_AQUARIUM, aquariumName, fishPriceSum + decorationsPriceSum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        for (Aquarium aquarium : this.aquariums) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
