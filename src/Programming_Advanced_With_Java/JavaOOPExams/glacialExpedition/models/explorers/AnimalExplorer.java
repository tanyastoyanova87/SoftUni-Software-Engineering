package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer {
    private static final double INITIAL_ENERGY = 100;
    public AnimalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }
}
