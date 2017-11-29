package projectoop;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by aqali on 27.11.2017.
 */
public class Storage {
    public static HashMap<String, Person> people = new HashMap<>();
    private static HashSet<Course> courses = new HashSet<>();
    private static HashSet<CourseFile> courseFiles = new HashSet<>();
    private static HashSet<Mark> marks = new HashSet<>();

    public static HashSet<Admin> admins = new HashSet<>();
    public static HashSet<Student> students = new HashSet<>();
    public static HashSet<Teacher> teachers = new HashSet<>();
    public static HashSet<Manager> managers = new HashSet<>();
    public static HashSet<Executor> executors = new HashSet<>();

    public static void serializeData() {
        Util.Serialize(people, "people.txt");
        Util.Serialize(courses, "courses.txt");
        Util.Serialize(courseFiles, "courseFiles.txt");
        Util.Serialize(marks, "marks.txt");

        Util.Serialize(admins, "admins.txt");
        Util.Serialize(students, "students.txt");
        Util.Serialize(teachers, "teachers.txt");
        Util.Serialize(managers, "manager.txt");
        Util.Serialize(executors, "executors.txt");
    }

    public static void deserializeData() {
        people = (HashMap<String, Person>) Util.Deserialize("people.txt");
        courses = (HashSet<Course>) Util.Deserialize("courses.txt");
        courseFiles = (HashSet<CourseFile>) Util.Deserialize("courseFiles.txt");
        marks = (HashSet<Mark>) Util.Deserialize("marks.txt");

        admins = (HashSet<Admin>) Util.Deserialize("admins.txt");
        students = (HashSet<Student>) Util.Deserialize("students.txt");
        teachers = (HashSet<Teacher>) Util.Deserialize("teachers.txt");
        manager = (HashSet<Manager>) Util.Deserialize("manager.txt");
        executors = (HashSet<Executor>) Util.Deserialize("executors.txt");
    }

    public static Person getPerson(String login) throws UserNotFoundException {
        if (!people.containsKey(login))
            throw new UserNotFoundException();
        return people.get(login);
    }

    public static void removePerson(String id) {
    }
}
