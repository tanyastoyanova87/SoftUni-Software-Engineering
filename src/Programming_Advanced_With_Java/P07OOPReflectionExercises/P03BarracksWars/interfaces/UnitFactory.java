package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}