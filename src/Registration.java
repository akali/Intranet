import java.util.Vector;

/**
 * Created by aqali on 26.11.2017.
 */
public class Registration {
    public static Vector<Registration> registrations = new Vector<>();
    enum Type {
        ACCEPTED, REJECTED, PENDING
    }
    private Student student;
    private Course course;
    private Type type;
    public void addRegitration(Registration registration) {
        registrations.add(registration);
    }

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.type = Type.PENDING;
    }

    public static Vector<Registration> getRegistrations() {
        return registrations;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void acceptRegistration(Teacher teacher) {
        student.getCourses().add(course);
        student.setTeacher(course, teacher);
        type = Type.ACCEPTED;
    }

    public void rejectRegitration() {
        type = Type.REJECTED;
    }
}
