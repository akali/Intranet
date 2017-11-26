import java.util.HashMap;
import java.util.TreeSet;

public class Student extends Person {
    private double gpa;

    private TreeSet<Course> current;
    private TreeSet<Course> passed;

    private HashMap<Course, Mark> marks;
    private static TreeSet<Student> students;

    private HashMap<Course, Teacher> teachers;
    public void registerForCourse(Course c) {
    }

    public TreeSet<Course> getCourses() {
        return null;
    }
    public CourseFile getCourseFile(Course c) {
        return null;
    }
    public HashMap<Course, Mark> getMarks() {
        return null;
    }
    public Transcript getTranscript() {
        return null;
    }

    public void rateTeacher(Rate r, Teacher t) {
    }

    public Teacher getTeacher(Course c) {
        return null;
    }

    @Override
    public void view() {

    }

    public void setTeacher(Course course, Teacher teacher) {
        teachers.put(course, teacher);
    }
}

