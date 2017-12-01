package projectoop;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import java.util.*;

public class Teacher extends Employee {
    public void addCourse(Course c) {
        courses.add(c);
    }

    private enum Degree implements Serializable {
        BACHELOR, MASTER, PHD
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    private Degree degree;

    public Teacher() { }
    public Teacher(String id, String password, String name, int salary, Degree degree) {
        super(id, password, name, salary);
        this.degree = degree;
    }

    @Override
    public Person create(Person s) {
        Teacher result = (Teacher) super.create(s);
        int num = Util.pickView("degree", (Object[]) Degree.values()) - 1;
        result.setDegree(Degree.values()[num]);
        return result;
    }

    @Override
    public void update() {
        super.update();
        setDegree(Degree.values()[Util.pickView("degree", (Object[]) Degree.values()) - 1]);
    }

    private HashMap<Course, Student> students = new HashMap<>();

    public void addStudent(Course c, Student s) {
        students.put(c, s);
    }

    private HashMap<Student, Rate> rate = new HashMap<>();
    private HashSet<Course> courses = new HashSet<>();

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void addRate(Student s, Rate t) {
        rate.put(s, t);
    }

    @Override
    public boolean view() {
        System.out.println(toString());
        switch (Util.pickView("action",
                "View courses",
                "View students",
                "Send order",
                "Exit")) {
            case 1:
                viewCourses();
                break;
            case 2:
                viewStudents();
                break;
            case 3:
                sendOrder(Order.create(this));
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    private void viewStudents() {
        HashSet<Student> students = StorageSingletone.getInstance().getStudents();
        int num = Util.pickView(students, "student") - 1;
        Student picked = (Student) Util.getPicked(students, num);
        System.out.println(picked);
        Util.askGet(Util.getReadingScanner(),"Press any key to continue");
    }

    private void viewCourses() {
        int num = Util.pickView(courses, "course") - 1;
        if (num >= courses.size() || num < 0) {
            System.out.println("Wrong number");
            return;
        }
        Course picked = (Course) Util.getPicked(courses, num);
        switch (Util.pickView("action",
                "View course file",
                "View student")) {
            case 1:
                manageCourseFile(picked);
                break;
            case 2:
                viewStudent(picked);
                break;
            default:
                break;
        }
    }

    private void manageCourseFile(Course course) {
        switch (Util.pickView("action",
                "Create",
                "View",
                "Cancel")) {
            case 1:
                course.setCourseFiles(CourseFile.create());
                break;
            case 2:
                System.out.println(course.getCourseFiles().pretty());
                break;
            default:
                break;
        }
    }

    private void viewStudent(Course course) {
        HashSet<Student> s = course.getStudents();
        int num = Util.pickView(s, "student") - 1;
        if (num < 0 || num >= s.size()) {
            System.out.println("Wrong input");
            return;
        }
        Student picked = (Student) Util.getPicked(s, num);
        switch (Util.pickView("action",
                "Put mark",
                "Cancel")) {
            case 1:
                picked.getMark(course).view();
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "degree=" + degree +
                ", rate=" + rate +
                "} " + super.toString();
    }

    public void sendOrder(Order o) {
        StorageSingletone.getInstance().addOrder(o);
    }
}

