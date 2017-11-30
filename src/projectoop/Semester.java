package projectoop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

/**
 */
public class Semester implements Serializable {
    private Vector<Course> courses;
    private HashMap<Course, Mark> marks;
    public void addCourse(Course c) {
    }
    public void setMark(Course c, Mark m) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semester semester = (Semester) o;

        if (courses != null ? !courses.equals(semester.courses) : semester.courses != null) return false;
        return marks != null ? marks.equals(semester.marks) : semester.marks == null;
    }

    @Override
    public int hashCode() {
        int result = courses != null ? courses.hashCode() : 0;
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        return result;
    }
}

