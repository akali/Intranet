package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.Arrays;
import java.util.Vector;

public class Option implements Cloneable, Serializable {
    public Option(String description) {
        this.description = description;
    }

    static Vector<Option> options = new Vector<>(Arrays.asList(
            new Option("Question 1"),
            new Option("Question 2"),
            new Option("Question 3")
    ));
    private String description;
    private int rate;

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (rate != option.rate) return false;
        return description != null ? description.equals(option.description) : option.description == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + rate;
        return result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

