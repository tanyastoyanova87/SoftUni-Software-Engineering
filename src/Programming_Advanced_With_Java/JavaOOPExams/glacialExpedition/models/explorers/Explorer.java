package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers;

import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.suitcases.Suitcase;

public interface Explorer {
    String getName();

    double getEnergy();

    boolean canSearch();

    Suitcase getSuitcase();

    void search();
}
