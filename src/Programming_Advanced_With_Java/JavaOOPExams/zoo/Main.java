package Programming_Advanced_With_Java.JavaOOPExams.zoo;

import Programming_Advanced_With_Java.JavaOOPExams.zoo.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.zoo.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
