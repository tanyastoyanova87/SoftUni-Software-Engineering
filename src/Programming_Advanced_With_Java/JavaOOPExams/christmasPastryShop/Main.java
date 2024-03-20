package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop;

import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.core.ControllerImpl;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.core.EngineImpl;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.core.interfaces.Controller;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.entities.booths.interfaces.Booth;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.io.ConsoleReader;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.io.ConsoleWriter;
import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
