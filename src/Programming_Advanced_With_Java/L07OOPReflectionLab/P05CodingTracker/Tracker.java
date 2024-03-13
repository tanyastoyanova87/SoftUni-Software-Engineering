package Programming_Advanced_With_Java.L07OOPReflectionLab.P05CodingTracker;

import java.lang.reflect.Method;

public class Tracker {

    @Author(element = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(element = "Peter")
    public static void printMethodsByAuthor(Class<Tracker> trackerClass) {
        Method[] declaredMethods = trackerClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Author annotation = declaredMethod.getAnnotation(Author.class);
            System.out.println(annotation.element() + ": " + declaredMethod.getName());
        }
    }
}
