package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.commands;

public class FightCommand extends Command {
    public FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
