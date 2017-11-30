package projectoop;

import java.util.HashMap;
import java.util.HashSet;

public class StorageSingletone {
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
    private HashSet<Mark> marks = new HashSet<>();

    private HashSet<Admin> admins = new HashSet<>();
    private HashSet<Student> students = new HashSet<>();
    private HashSet<Teacher> teachers = new HashSet<>();
    private HashSet<Manager> managers = new HashSet<>();
    private HashSet<Executor> executors = new HashSet<>();
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
        Util.Serialize(this, "save");
    }
    public void load() {
        Util.Deserialize("save");
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

    public void removeEntity(String login) {
        Person p = people.get(login);
        getEntitiesSet(p.getClass()).remove(p);
        people.remove(login);
    }

}
