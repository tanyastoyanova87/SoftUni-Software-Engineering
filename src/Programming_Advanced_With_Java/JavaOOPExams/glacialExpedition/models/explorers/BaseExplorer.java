package Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.explorers;

import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.suitcases.Carton;
import Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.models.suitcases.Suitcase;

import static Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static Programming_Advanced_With_Java.JavaOOPExams.glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        this.energy -= 15;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }
}
