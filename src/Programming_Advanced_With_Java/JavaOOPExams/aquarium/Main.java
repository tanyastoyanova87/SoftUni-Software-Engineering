package Programming_Advanced_With_Java.JavaOOPExams.aquarium;

import Programming_Advanced_With_Java.JavaOOPExams.aquarium.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
