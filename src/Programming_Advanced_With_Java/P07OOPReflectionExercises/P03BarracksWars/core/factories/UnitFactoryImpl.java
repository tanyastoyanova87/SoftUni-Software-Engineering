package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.factories;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Unit;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String className = UNITS_PACKAGE_NAME + unitType;
		Class<Unit> unitClass = (Class<Unit>) Class.forName(className);
		Constructor<Unit> declaredConstructor = unitClass.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		return declaredConstructor.newInstance();
	}
}
