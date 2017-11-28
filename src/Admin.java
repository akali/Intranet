import java.util.Arrays;
import java.util.Vector;

public class Admin extends Employee {
    private static Admin INSTANCE = new Admin();

    public Admin(String id, String password, String name, int salary) {
		super(id, password, name, salary);
	}

    private Admin() {
        super();
    }

    public static Admin getInstance() {
        return INSTANCE;
    }

    public void createStudent(Student e) {

    }
    public void createTeacher(Teacher t) {

    }
    public void createManager(Manager m) {

    }
    public void createAdmin(Admin a) {}

    public int createExecutor(int e) {
        return 0;
    }
    public boolean removeStudent(Student s) {
        return false;
    }
    public boolean removeManager(Manager m) {
        return false;
    }

    public boolean removeTeacher(int t) {
        return false;
    }

    public boolean removeExecutor(int e) {
        return false;
    }

    public void updateStudent(int id, Student s) {
    }

    public void updateTeacher(int id, int t) {
    }

    public void updateManager(int id, Manager m) {
    }

    public void updateExecutor(int id, int e) {
    }

    @Override
    public boolean view() {
        Vector<String> actions = new Vector<>
                (Arrays.asList(new String[]{"Create",
                        "Update",
                        "Delete",
                        "Exit"
                }));
        switch (Util.pickView(actions, "action")) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                return false;
            default:
                System.out.println("Incorrect command!");
                break;
        }
        return false;
    }

    public Admin create() {
        Vector<String> entities = new Vector<>
                (Arrays.asList(new String[]{"Student",
                        "Teacher",
                        "Admin",
                        "Manager",
                        "Cancel"
                }));
        switch (Util.pickView(entities, "entity")) {
            case 1:
                Student s = (Student) Student.getInstance().create(new Student());
                createStudent(s);
                break;
            case 2:
                Teacher t = (Teacher) Teacher.getInstance().create(new Teacher());
                createTeacher(t);
                break;
            case 3:
                Admin a = (Admin) Admin.getInstance().create(new Admin());
                createAdmin(a);
                break;
        }
        return null;
    }

    private Admin createAdmin() {
        return null;
    }

    public void delete() {

    }

    public void update() {

    }
}

