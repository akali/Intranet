import java.util.*;

public class Student extends Person {
    private double gpa = 4.0;

    private TreeSet<Course> current = new TreeSet<>();
    private TreeSet<Course> passed = new TreeSet<>();

    private HashMap<Course, Mark> marks = new HashMap<>();
    private static TreeSet<Student> students = new TreeSet<>();

    private HashMap<Course, Teacher> teachers = new HashMap<>();
    public void registerForCourse(Course c) {
        Registration.addRegitration(new Registration(this, c));
    }
    public TreeSet<Course> getCourses() {
        return current;
    }
    public CourseFile getCourseFile(Course c) {
        return c.getCourseFiles();
    }
    public HashMap<Course, Mark> getMarks() {
        return marks;
    }
    public Mark getMark(Course c) {
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
        Scanner sc = new Scanner(System.in);
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
        sc.close();
    }

    public Teacher getTeacher(Course c) {
        return c.getTeacher();
    }

    @Override
    public boolean view() {
        switch (Util.pickView("action",
                "View courses",
                "Register to course",
                "View transcript",
                "Exit")) {
            case 1: viewCourses(); break;
            case 2: registerCourse(); break;
            case 3: viewTranscript(); break;
            case 4: return false;
            default: break;
        }
        return true;
    }

    private void viewTranscript() {
    }

    private void registerCourse() {
    }

    private void viewCourses() {
        Vector<Course> list = new Vector<Course>(Arrays.<Course>asList((Course[]) current.toArray()));
        int num = Util.pickView(list, "course") - 1;
        if (num >= list.size()) {
            System.out.println("Wrong number");
            return;
        }
        switch (Util.pickView("action",
                "View course file",
                "View teacher",
                "View mark")) {
            case 1: System.out.println(list.get(num).getCourseFiles().pretty()); break;
            case 2: viewTeacher(list.get(num)); break;
            case 3: System.out.println(getMark(list.get(num)).toString()); break;
            case 4: break;
            default: break;
        }
    }

    private void viewTeacher(Course course) {
        Teacher t = getTeacher(course);
        System.out.println(t);
        switch (Util.pickView("action",
                "Rate teacher",
                "Cancel")) {
            case 1: createTeacherRating(t); break;
            case 2: break;
            default: System.out.println("Wrong input"); break;
        }
    }

    public void setTeacher(Course course, Teacher teacher) {
        teachers.put(course, teacher);
    }

    private static Student INSTANCE = new Student();
    public static Student getInstance() {
        return INSTANCE;
    }
    public Student() {
        super();
    }
}

