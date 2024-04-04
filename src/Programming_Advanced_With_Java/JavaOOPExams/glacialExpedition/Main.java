package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition;

import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.core.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.core.ControllerImpl;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.core.Engine;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
