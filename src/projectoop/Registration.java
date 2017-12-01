package projectoop;

import java.io.Serializable;

public class Registration implements Serializable {
    enum Type {
        ACCEPTED, REJECTED, PENDING
    }
    private Student student;
    private Course course;
    private Type type;
    public static void addRegistration(Registration registration) {
        StorageSingletone.getInstance().addRegistration(registration);
    }

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.type = Type.PENDING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        return (student != null ? student.equals(that.student) : that.student == null) &&
                (course != null ? course.equals(that.course) : that.course == null) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        int result = student != null ? student.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
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

    public void acceptRegistration() {
        student.getCourses().add(course);
        student.setTeacher(course, course.getTeacher());
        type = Type.ACCEPTED;
    }

    public void rejectRegitration() {
        type = Type.REJECTED;
    }
}
