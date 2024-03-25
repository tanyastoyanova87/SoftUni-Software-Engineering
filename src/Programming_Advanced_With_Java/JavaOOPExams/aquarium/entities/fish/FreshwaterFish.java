package Programming_Advanced_With_Java.JavaOOPExams.aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {
    private static final int INITIAL_SIZE = 3;
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    protected void setSize(int size) {
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        this.setSize(INITIAL_SIZE + 3);
    }
}
