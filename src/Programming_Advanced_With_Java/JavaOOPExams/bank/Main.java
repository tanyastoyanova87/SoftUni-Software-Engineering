package Programming_Advanced_With_Java.JavaOOPExams.bank;

import Programming_Advanced_With_Java.JavaOOPExams.bank.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.bank.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
