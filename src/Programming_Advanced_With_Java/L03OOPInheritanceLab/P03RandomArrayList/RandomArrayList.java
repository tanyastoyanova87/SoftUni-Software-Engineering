package Programming_Advanced_With_Java.L03OOPInheritanceLab.P03RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {
    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(0, size());
        return remove(index);
    }
}
