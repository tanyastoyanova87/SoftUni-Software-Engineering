package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionLab.P03SayHelloP04SayHelloExtended;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
