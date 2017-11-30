package projectoop;

import java.util.HashMap;
import java.util.Vector;
import java.util.*;

public class Teacher extends Employee {
    public Teacher() { }
    public Teacher(String id, String password, String name, int salary) {
        super(id, password, name, salary);
    }

    private HashMap<Course, Student> students = new HashMap<>();

    private HashMap<Student, Rate> rate = new HashMap<>();
    private HashSet<Course> courses = new HashSet<>();

    public void addRate(Student s, Rate t) {
        rate.put(s, t);
    }

    @Override
    public boolean view() {
        switch (Util.pickView("action",
                "View courses",
                "View students",
                "Send order",
                "Exit")) {
            case 1: viewCourses(); break;
            case 2: viewStudents(); break;
            case 3: orderSend(); break;
            case 4: return false;
            default: break;
        }
        return true;
    }

    private void orderSend() {

    }

    private void viewStudents() {
    }

    private void viewCourses() {
        Vector<Course> list = new Vector<>(Arrays.asList((Course[]) courses.toArray()));
        int num = Util.pickView(list, "course") - 1;
        if (num >= list.size() || num < 0) {
            System.out.println("Wrong number");
            return;
        }
        switch (Util.pickView("action",
                "View course file",
                "View student",
                "Send Order")) {
            case 1:
                System.out.println(list.get(num).getCourseFiles().pretty());
                break;
            case 2:
                viewStudent(list.get(num));
                break;
            case 3:
                StorageSingletone.getInstance().addOrder(Order.create(this));
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

    public void setStudent(Course course, Student s) {
        students.put(course, s);
    }

    public void sendOrder(Order o) {
        StorageSingletone.getInstance().addOrder(o);
    }
}

