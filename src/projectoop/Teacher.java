package projectoop;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.*;

public class Teacher extends Employee {
    public Teacher(String id, String password, String name, int salary) {
        super(id, password, name, salary);
        // TODO Auto-generated constructor stub
    }

    private static TreeSet<Teacher> teachers;

    private HashMap<Course, Student> students = new HashMap<>();
    private TreeSet<Course> courses;

    private HashMap<Course, Mark> marks = new HashMap<>();
    private HashMap<Student, Rate> rate = new HashMap<>();
    private TreeSet<Course> current = new TreeSet<>();

    public void addRate(Student s, Rate t) {
        rate.put(s, t);
    }

    public void setTeachers(TreeSet<Teacher> teacher) {
        this.teachers = teachers;
    }

    public void setCourses(TreeSet<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(HashMap<Course, Student> students) {
        this.students = students;
    }

    public TreeSet<Teacher> getTeacher(){
        return this.teachers;
    }
    public TreeSet<Course> getCourse(){
        return this.courses;
    }
    public HashMap<Course, Student> getStudents(){
        return this.students;
    }

    public boolean viewT() {
        switch (Util.pickView("action",
                "View courses",
                "View transcript",
                "Exit")) {
            case 1: viewCourses(); break;
            case 2: viewTranscript(); break;
            case 3: return false;
            default: break;
        }
        return true;
    }
    private void viewTranscript() {
        // TODO Auto-generated method stub

    }

    private void viewCourses() {
        Vector<Course> list = new Vector<>(Arrays.asList((Course[]) current.toArray()));
        int num = Util.pickView(list, "course") - 1;
        if (num >= list.size() || num < 1) {
            System.out.println("Wrong number");
            return;
        }
        switch (Util.pickView("action",
                "View course file",
                "View student",
                "View mark")) {
            case 1: System.out.println(list.get(num).getCourseFiles().pretty()); break;
//            case 2: viewStudent(list.get(num)); break;
            case 3: System.out.println(getMark(list.get(num)).toString()); break;
            case 4: break;
            default: break;
        }
    }
//    private void viewStudent(Course course) {
//        Student s = getStudent(course);
//        System.out.println(s);
//        switch (Util.pickView("action",
//                // "projectoop.Rate teacher",
//                "Cancel")) {
//            //не придумал пока экшн, утром завтра при встрече
//            case 2: break;
//            default: System.out.println("Wrong input"); break;
//        }
//    }

//    private Student getStudent(Course course) {
//        students.getStudent();//????
//    }
//    public void setStudent(Course course, Student s) {
//        students.put(course, s);
//    }


    public void sendOrder(Order o, Executor e) {
    }
    public Mark getMark(Course c) {
        return marks.get(c);
    }

    @Override
    public boolean view() {

        return false;
    }

    private static Teacher INSTANCE = new Teacher();
    public static Teacher getInstance() {
        return INSTANCE;
    }
    public Teacher() {
        super();
    }
}

