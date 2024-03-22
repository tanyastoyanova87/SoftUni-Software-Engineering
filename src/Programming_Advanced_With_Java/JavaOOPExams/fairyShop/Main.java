package Programming_Advanced_With_Java.JavaOOPExams.fairyShop;

import Programming_Advanced_With_Java.JavaOOPExams.fairyShop.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
