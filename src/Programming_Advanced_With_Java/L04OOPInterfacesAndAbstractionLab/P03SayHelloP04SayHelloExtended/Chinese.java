package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P03SayHelloP04SayHelloExtended;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
