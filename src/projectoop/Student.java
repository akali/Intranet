package projectoop;

import java.util.*;

public class Student extends Person {
    private double gpa = 4.0;

    private HashSet<Course> current = new HashSet<>();
    private HashSet<Course> passed = new HashSet<>();

    private HashMap<Course, Mark> marks = new HashMap<>();

    private HashMap<Course, Teacher> teachers = new HashMap<>();
    public void registerForCourse(Course c) {
        Registration.addRegistration(new Registration(this, c));
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
        Scanner sc = Util.getReadingScanner();
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
        Vector<Course> list = new Vector<>(Arrays.asList((Course[]) current.toArray()));
        int num = Util.pickView(list, "course") - 1;
        if (num >= list.size() || num < 1) {
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
                "projectoop.Rate teacher",
                "Cancel")) {
            case 1: createTeacherRating(t); break;
            case 2: break;
            default: System.out.println("Wrong input"); break;
        }
    }

    public void setTeacher(Course course, Teacher teacher) {
        teachers.put(course, teacher);
    }

    public Student() {
        super();
    }


}

