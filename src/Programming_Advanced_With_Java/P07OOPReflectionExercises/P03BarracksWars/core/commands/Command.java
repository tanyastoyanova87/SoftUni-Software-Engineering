package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.commands;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

}
