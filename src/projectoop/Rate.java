package projectoop;

import java.io.Serializable;
import java.util.Vector;

public class Rate implements Serializable {
    private Vector<Option> options;
    public void addOption(Option o) {
        options.add(o);
    }
}

