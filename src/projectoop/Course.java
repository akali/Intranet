package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Vector;

public class Course implements Serializable {
    private String name, id;
    private Teacher teacher;
    private HashSet<Student> students = new HashSet<>();
    private HashSet<Course> prerequisites = new HashSet<>();
    private CourseFile courseFiles;
    private int creditsNumber;
    private Faculty faculty;

    public Course() { }

    public Course(String name, String id, Teacher teacher, int creditsNumber, Faculty faculty) {
        this.name = name;
        this.id = id;
        this.teacher = teacher;
        this.creditsNumber = creditsNumber;
        this.faculty = faculty;
    }

    public static Course create() {
        String name = Util.askGet(Util.getReadingScanner(), "Enter name");
        String id = Util.askGet(Util.getReadingScanner(), "Enter id");
        int creditsNumber = Integer.parseInt(Util.askGet(Util.getReadingScanner(), "Enter number of credits"));
        HashSet<Teacher> teachers = StorageSingletone.getInstance().getTeachers();
        int num = Util.pickView(teachers, "teacher") - 1;
        Faculty faculty = Faculty.create();
        return new Course(name, id, (Teacher) Util.getPicked(teachers, num), creditsNumber, faculty);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public HashSet<Course> getPrerequisites() {
        return prerequisites;
    }

    public void addPrerequisite(Course c) {
        this.prerequisites.add(c);
    }

    public CourseFile getCourseFiles() {
        return courseFiles;
    }

    public void setCourseFiles(CourseFile courseFiles) {
        this.courseFiles = courseFiles;
    }

    public int getCreditsNumber() {
        return creditsNumber;
    }

    public void setCreditsNumber(int creditsNumber) {
        this.creditsNumber = creditsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (creditsNumber != course.creditsNumber) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (id != null ? !id.equals(course.id) : course.id != null) return false;
        if (teacher != null ? !teacher.equals(course.teacher) : course.teacher != null) return false;
        if (students != null ? !students.equals(course.students) : course.students != null) return false;
        if (prerequisites != null ? !prerequisites.equals(course.prerequisites) : course.prerequisites != null)
            return false;
        return courseFiles != null ? courseFiles.equals(course.courseFiles) : course.courseFiles == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (prerequisites != null ? prerequisites.hashCode() : 0);
        result = 31 * result + (courseFiles != null ? courseFiles.hashCode() : 0);
        result = 31 * result + creditsNumber;
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                ", prerequisites=" + prerequisites +
                ", courseFiles=" + courseFiles +
                ", creditsNumber=" + creditsNumber +
                '}';
    }

    public Faculty getFaculty() {
        return faculty;
    }
}

