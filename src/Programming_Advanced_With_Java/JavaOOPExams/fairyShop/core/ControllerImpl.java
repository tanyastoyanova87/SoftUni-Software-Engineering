package Programming_Advanced_With_Java.JavaOOPExams.fairyShop.core;

import Programming_Advanced_With_Java.JavaOOPExams.fairyShop.models.*;
import Programming_Advanced_With_Java.JavaOOPExams.fairyShop.repositories.HelperRepository;
import Programming_Advanced_With_Java.JavaOOPExams.fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Programming_Advanced_With_Java.JavaOOPExams.fairyShop.common.ConstantMessages.*;
import static Programming_Advanced_With_Java.JavaOOPExams.fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository<Helper> helperRepository;
    private PresentRepository<Present> presentRepository;
    private Shop shop;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository<>();
        this.presentRepository = new PresentRepository<>();
        this.shop = new ShopImpl();
    }


    @Override
    public String addHelper(String type, String helperName) {

        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);

        }
        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        this.presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = this.presentRepository.findByName(presentName);
        List<Helper> helpers = this.helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());
        if (helpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        List<Instrument> brokenInstruments = new ArrayList<>();

        for (Helper helper : helpers) {
            shop.craft(present, helper);
            brokenInstruments = helper.getInstruments().stream().filter(Instrument::isBroken).collect(Collectors.toList());
            if (present.isDone()) {
                break;
            }
        }

        String doneOrUndone;
        if (present.isDone()) {
            doneOrUndone = "done";
        } else {
            doneOrUndone = "not done";
            presentRepository.remove(present);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PRESENT_DONE, presentName, doneOrUndone));
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments.size()));
        return sb.toString();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!%n", presentRepository.getModels().size()));
        sb.append("Helpers info:");
        sb.append(System.lineSeparator());
        for (Helper helper : helperRepository.getModels()) {
            sb.append(String.format("Name: %s%n", helper.getName()));
            sb.append(String.format("Energy: %d%n", helper.getEnergy()));
            List<Instrument> notBroken = helper.getInstruments().stream()
                    .filter(instrument -> !instrument.isBroken()).collect(Collectors.toList());
            sb.append(String.format("Instruments: %d not broken left%n", notBroken.size()));

        }
        return sb.toString().trim();
    }
}
