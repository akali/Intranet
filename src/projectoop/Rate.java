package projectoop;

import java.io.Serializable;
import java.util.Vector;

public class Rate implements Serializable {
    private Vector<Option> options;
    public void addOption(Option o) {
        options.add(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        return options != null ? options.equals(rate.options) : rate.options == null;
    }

    @Override
    public int hashCode() {
        return options != null ? options.hashCode() : 0;
    }
}

