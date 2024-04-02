package Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.region;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());

        List<Magician> blackWidows = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("Black Widow"))
                .collect(Collectors.toList());

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            Magician wizard = wizards.get(0);
            Magician blackWidow = blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if (blackWidow.isAlive()) {
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()) {
                    wizards.remove(wizard);
                }
            } else {
                blackWidows.remove(blackWidow);
            }
        }
        if (wizards.size() > blackWidows.size()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
