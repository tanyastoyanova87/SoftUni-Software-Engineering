package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Repository;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Runnable;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.UnitFactory;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.Engine;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.factories.UnitFactoryImpl;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
