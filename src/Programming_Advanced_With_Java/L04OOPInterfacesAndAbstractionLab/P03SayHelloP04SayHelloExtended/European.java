package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P03SayHelloP04SayHelloExtended;

public class European extends BasePerson {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
