package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver;

import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.core.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.core.ControllerImpl;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
