package Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.io;

import Programming_Advanced_With_Java.JavaOOPExams.christmasPastryShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
