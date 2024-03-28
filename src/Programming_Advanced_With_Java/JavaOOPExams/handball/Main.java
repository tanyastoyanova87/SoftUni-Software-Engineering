package Programming_Advanced_With_Java.JavaOOPExams.handball;

import Programming_Advanced_With_Java.JavaOOPExams.handball.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.handball.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
