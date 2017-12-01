package projectoop;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class StorageSingletone implements Serializable {
    @Override
    public String toString() {
        return "StorageSingletone{" +
                "people=" + people +
                ", courses=" + courses +
                ", courseFiles=" + courseFiles +
                ", marks=" + marks +
                ", admins=" + admins +
                ", students=" + students +
                ", teachers=" + teachers +
                ", managers=" + managers +
                ", executors=" + executors +
                ", orders=" + orders +
                ", F=" + F +
                ", G=" + G +
                '}';
    }

    public static void setInstance(StorageSingletone instance) {
        StorageSingletone.instance = instance;
    }

    private static StorageSingletone instance = new StorageSingletone();
    private StorageSingletone() {
        G.put(Admin.class, "A");
        G.put(Student.class, "S");
        G.put(Teacher.class, "T");
        G.put(Manager.class, "M");
        G.put(Executor.class, "E");

        F.put(Admin.class, admins);
        F.put(Student.class, students);
        F.put(Teacher.class, teachers);
        F.put(Manager.class, managers);
        F.put(Executor.class, executors);
    }

    public static StorageSingletone getInstance() {
        return instance;
    }

    private HashMap<String, Person> people = new HashMap<>();
    private HashSet<Course> courses = new HashSet<>();
    private HashSet<CourseFile> courseFiles = new HashSet<>();
    private Vector<Mark> marks = new Vector<>();

    private HashSet<Admin> admins = new HashSet<>();
    private HashSet<Student> students = new HashSet<>();
    private HashSet<Teacher> teachers = new HashSet<>();
    private HashSet<Manager> managers = new HashSet<>();
    private HashSet<Executor> executors = new HashSet<>();
    private Vector<Order> orders = new Vector<>();

    private HashSet<Registration> registrations = new HashSet<>();

    private TreeSet<News> news = new TreeSet<>();

    public void addOrder(Order o) {
        orders.add(o);
    }

    public Vector<Order> getOrders() {
        return orders;
    }

    private HashMap<Class<?>, HashSet> F = new HashMap<>();
    private HashMap<Class<?>, String> G = new HashMap<>();

    public Person getPerson(String login) throws UserNotFoundException {
        if (!people.containsKey(login))
            throw new UserNotFoundException();
        return people.get(login);
    }

    public void removePerson(String login) {
        people.remove(login);
    }

    public void save() {
        System.out.println(instance);
        projectoop.Util.Serialize(instance, "save");
    }
    public static StorageSingletone load() {
        if (new File("save").exists())
            return (StorageSingletone) projectoop.Util.Deserialize("save");
        return instance;
    }

    public HashSet getEntitiesSet(Class<?> klas) {
        return F.get(klas);
    }

    public String insertAndGenerateId(Person p) {
        F.get(p.getClass()).add(p);
        String login = G.get(p.getClass()) + F.get(p.getClass()).size();
        people.put(login, p);
        return login;
    }

    public HashSet<Registration> getRegistrations() {
        return registrations;
    }

    public void removeEntity(String login) {
        Person p = people.get(login);

        getEntitiesSet(p.getClass()).remove(p);
        people.remove(login);
    }

    public void addNews(News n) {
        news.add(n);
    }

    public void removeNews(News n) {
        news.remove(n);
    }

    public void addRegistration(Registration registration) {
        registrations.add(registration);
    }

    public void removeRegistration(Registration picked) {
        registrations.remove(picked);
    }

    public HashSet<Teacher> getTeachers() {
        return teachers;
    }

    public TreeSet<News> getNews() {
        return news;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course c) {
        courses.add(c);
    }
}
