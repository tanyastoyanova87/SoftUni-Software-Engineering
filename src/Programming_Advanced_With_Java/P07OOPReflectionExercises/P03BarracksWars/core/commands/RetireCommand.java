package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.commands;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.Inject;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Repository;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];
      this.repository.removeUnit(unitType);

      return unitType + " retired!";
    }
}
