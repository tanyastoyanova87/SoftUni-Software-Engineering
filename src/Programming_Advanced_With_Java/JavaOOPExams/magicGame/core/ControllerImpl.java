package Programming_Advanced_With_Java.JavaOOPExams.magicGame.core;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians.BlackWidow;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians.Magician;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians.Wizard;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.BlackMagic;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.Magic;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.RedMagic;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.region.Region;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.region.RegionImpl;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.repositories.interfaces.MagicRepositoryImpl;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.ExceptionMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGIC;
import static Programming_Advanced_With_Java.JavaOOPExams.magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN;

public class ControllerImpl implements Controller {
    private MagicRepositoryImpl magicRepository;
    private MagicianRepositoryImpl magicianRepository;
    private Region region;

    public ControllerImpl() {
        this.magicRepository = new MagicRepositoryImpl();
        this.magicianRepository = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;
        switch (type) {
            case "RedMagic":
                magic = new RedMagic(name, bulletsCount);
                break;
            case "BlackMagic":
                magic = new BlackMagic(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }

        this.magicRepository.addMagic(magic);
        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magicRepository.findByName(magicName);
        if (magic == null) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }
        Magician magician;
        switch (type) {
            case "BlackWidow":
                magician = new BlackWidow(username, health, protection, magic);
                break;
            case "Wizard":
                magician = new Wizard(username, health, protection, magic);
                break;
            default:
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }

        this.magicianRepository.addMagician(magician);
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return region.start(magicianRepository.getData());
    }

    @Override
    public String report() {
        List<Magician> magicianList = magicianRepository.getData().stream().sorted(Comparator.comparing(Magician::getHealth).thenComparing(Magician::getUsername)).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Magician magician : magicianList) {
            int health = magician.getHealth();
            if (magician.getHealth() < 0) {
                health = 0;
            }
            int protection = magician.getProtection();
            if (magician.getProtection() < 0) {
                protection = 0;
            }
            sb.append(String.format("%s: %s%n", magician.getClass().getSimpleName(), magician.getUsername()));
            sb.append(String.format("Health: %d%n", health));
            sb.append(String.format("Protection: %d%n", protection));
            sb.append(String.format("Magic: %s%n", magician.getMagic().getName()));
        }
        return sb.toString().trim();
    }
}
