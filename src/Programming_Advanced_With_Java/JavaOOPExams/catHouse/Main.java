package Programming_Advanced_With_Java.JavaOOPExams.catHouse;

import Programming_Advanced_With_Java.JavaOOPExams.catHouse.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
