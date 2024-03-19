package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.commands;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.Inject;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Repository;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Unit;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
