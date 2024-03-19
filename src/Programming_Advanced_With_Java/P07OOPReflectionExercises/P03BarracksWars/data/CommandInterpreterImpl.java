package Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.data;

import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.Inject;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.core.commands.Command;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.CommandInterpreter;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Executable;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.Repository;
import Programming_Advanced_With_Java.P07OOPReflectionExercises.P03BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String UNITS_PACKAGE_NAME = "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String clazzName = UNITS_PACKAGE_NAME +
                Character.toUpperCase(commandName.charAt(0)) +
                commandName.substring(1) +
                "Command";
        Class<Command> commandClass = (Class<Command>) Class.forName(clazzName);

        Constructor<Command> declaredConstructor =
                commandClass.getDeclaredConstructor(String[].class);

        Command command = declaredConstructor.newInstance((Object) data);

        Field[] declaredFields = commandClass.getDeclaredFields();

        Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        injectField(field, this.getClass().getDeclaredFields(), command);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return command;
    }

    private void injectField(Field field, Field[] fieldsToInject, Command command) throws IllegalAccessException {
        Field fieldToInject = Arrays.stream(fieldsToInject)
                .filter(f -> field.getType().equals(f.getType()))
                .findFirst()
                .orElse(null);


        if (null != fieldToInject) {
            fieldToInject.setAccessible(true);
            field.set(command, fieldToInject.get(this));
        }
    }
}
