package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P03BirthdayCelebrations;

public class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }


    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }
}
