package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ExecutionControl.NotImplementedException;

}
