package Programming_Advanced_With_Java.JavaOOPExams.football;

import Programming_Advanced_With_Java.JavaOOPExams.football.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
