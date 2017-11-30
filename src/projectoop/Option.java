package projectoop;

import java.lang.*;
import java.util.Arrays;
import java.util.Vector;

public class Option implements Cloneable {
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

