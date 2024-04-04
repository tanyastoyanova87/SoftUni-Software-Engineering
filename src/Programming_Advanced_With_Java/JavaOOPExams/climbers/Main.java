package Programming_Advanced_With_Java.JavaOOPExams.climbers;

import Programming_Advanced_With_Java.JavaOOPExams.climbers.core.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.core.ControllerImpl;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.climbers.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        //TODO
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
