package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P05BorderControl;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }
    @Override
    public String getId() {
        return this.id;
    }
}
