package Programming_Advanced_With_Java.JavaOOPExams.spaceStation;

import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.core.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.core.ControllerImpl;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
