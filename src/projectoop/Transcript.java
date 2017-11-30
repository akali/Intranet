package projectoop;

import java.io.Serializable;
import java.util.Vector;

/**
 */
public class Transcript implements Serializable {
    /**
     */
    private Vector<Semester> semester;

    /**
     */
    public void addSemester() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transcript that = (Transcript) o;

        return semester != null ? semester.equals(that.semester) : that.semester == null;
    }

    @Override
    public int hashCode() {
        return semester != null ? semester.hashCode() : 0;
    }
}

