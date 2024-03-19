package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.commands;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.Inject;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Repository;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
