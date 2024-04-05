package Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.models.divingSite;


import Programming_Advanced_With_Java.JavaOOPExams.harpoonDiver.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public class DivingSiteImpl implements DivingSite {
    private String name;
    Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        this.setName(name);
        this.seaCreatures = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
      return this.seaCreatures;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
