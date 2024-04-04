package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double INITIAL_ENERGY = 60;
    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        if (super.getEnergy() > 7) {
            super.setEnergy(super.getEnergy() - 7);
        } else {
            super.setEnergy(0);
        }
    }
}
