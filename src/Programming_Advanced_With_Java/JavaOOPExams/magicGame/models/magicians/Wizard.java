package Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magicians;

import Programming_Advanced_With_Java.JavaOOPExams.magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl {
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
