package Programming_Advanced_With_Java.JavaOOPExams.magicGame;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.magicGame.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
