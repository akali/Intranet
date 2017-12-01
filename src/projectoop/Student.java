package projectoop;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Student extends Person {
    @Override
    public Person create(Person s) {
        Student result = (Student) super.create(s);
        result.faculty = Faculty.values()[projectoop.Util.pickView("faculty",
                "FIT",
                "BS",
                "ISE") - 1];
        return result;
    }

    @Override
    public void update() {
        super.update();
        faculty = Faculty.values()[projectoop.Util.pickView("faculty",
                "FIT",
                "BS",
                "ISE") - 1];
    }

    private double gpa = 0.0;

    private Faculty faculty;
    private HashSet<Course> current = new HashSet<>();
    private HashSet<Course> passed = new HashSet<>();

    private HashMap<Course, Mark> marks = new HashMap<>();

    private HashMap<Course, Teacher> teachers = new HashMap<>();
    public void registerForCourse(Course c) {
        Registration.addRegistration(new Registration(this, c));
    }
    public HashSet<Course> getCourses() {
        return current;
    }
    public CourseFile getCourseFile(Course c) {
        return c.getCourseFiles();
    }
    public HashMap<Course, Mark> getMarks() {
        return marks;
    }
    public Mark getMark(Course c) {
        if (!marks.containsKey(c)) {
            marks.put(c, new Mark());
        }
        return marks.get(c);
    }
    public Transcript getTranscript() {

        return null;
    }

    public void rateTeacher(Rate r, Teacher t) {
        t.addRate(this, r);
    }

    private void createTeacherRating(Teacher teacher) {
        System.out.println("Put rate in range[1-5]");

        projectoop.Util.Scanner sc = projectoop.Util.getReadingScanner();
        Rate r = new Rate();
        for (Option o : Option.options) {
            try {
                Option t = (Option) o.clone();
                System.out.println(t.getDescription());
                t.setRate(sc.nextInt());
                r.addOption(t);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        rateTeacher(r, teacher);
    }

    public Teacher getTeacher(Course c) {
        return c.getTeacher();
    }

    @Override
    public boolean view() {
        System.out.println(toString());
        switch (projectoop.Util.pickView("action",
                "View courses",
                "Register to course",
                "View transcript",
                "Exit")) {
            case 1:
                viewCourses();
                break;
            case 2:
                registerCourse();
                break;
            case 3:
                viewTranscript();
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    private void viewTranscript() {
    }

    private void registerCourse() {
        HashSet<Course> courses = StorageSingletone.getInstance().getCourses();
        int num = projectoop.Util.pickView(courses, "course") - 1;
        if (num < 0 || num >= courses.size()) {
            System.out.println("Wrong input");
            return;
        }
        Course pickedCourse = (Course) projectoop.Util.getPicked(courses, num);
        registerForCourse(pickedCourse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (Double.compare(student.gpa, gpa) != 0) return false;
        if (faculty != student.faculty) return false;
        if (current != null ? !current.equals(student.current) : student.current != null) return false;
        if (passed != null ? !passed.equals(student.passed) : student.passed != null) return false;
        if (marks != null ? !marks.equals(student.marks) : student.marks != null) return false;
        return teachers != null ? teachers.equals(student.teachers) : student.teachers == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (current != null ? current.hashCode() : 0);
        result = 31 * result + (passed != null ? passed.hashCode() : 0);
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        result = 31 * result + (teachers != null ? teachers.hashCode() : 0);
        return result;
    }

    private void viewCourses() {
        int num = projectoop.Util.pickView(current, "course") - 1;
        if (num >= current.size() || num < 0) {
            System.out.println("Wrong number");
            return;
        }
        Course picked = (Course) Util.getPicked(current, num);
        switch (projectoop.Util.pickView("action",
                "View course file",
                "View teacher",
                "View mark")) {
            case 1:
                System.out.println(getCourseFile(picked).pretty());
                break;
            case 2:
                viewTeacher(picked);
                break;
            case 3:
                System.out.println(getMark(picked).toString());
                break;
            case 4:
                break;
            default:
                break;
        }

    }

    private void viewTeacher(Course course) {
        Teacher t = getTeacher(course);
        System.out.println(t);
        switch (projectoop.Util.pickView("action",
                "Rate teacher",
                "Cancel")) {
            case 1:
                createTeacherRating(t);
                break;
            case 2:
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
    }

    public void setTeacher(Course course, Teacher teacher) {
        teachers.put(course, teacher);
    }

    public Student() {
        super();
    }


    public Faculty getFaculty() {
        return faculty;
    }

    public int getCreditsNumber() {
        int cnt = 0;
        for (Course c : getCourses()){
            cnt += c.getCreditsNumber();
        }
        return cnt;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}

