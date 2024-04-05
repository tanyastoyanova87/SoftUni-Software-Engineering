package Programming_Advanced_With_Java.JavaOOPExams.viceCity;

import Programming_Advanced_With_Java.JavaOOPExams.viceCity.core.EngineImpl;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.core.interfaces.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.core.interfaces.ControllerImpl;
import Programming_Advanced_With_Java.JavaOOPExams.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl(); // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
