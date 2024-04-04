package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.core;

public interface Controller {
    String addExplorer(String type, String explorerName);

    String addState(String stateName, String... exhibits);

    String retireExplorer(String explorerName);

    String exploreState(String stateName);

    String finalResult();
}
