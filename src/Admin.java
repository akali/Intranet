import java.util.Vector;

public class Admin extends Employee {
    public Admin(String id, String password, String name,int salary) {
		super(id, password, name, salary);
		// TODO Auto-generated constructor stub
	}
    private static int studentId;

    private static int teacherId;

    private static int managerId;
    
    private static int executorId;

    public Student createStudent(Student e) {
        return null;
    }

    public int createTeacher(int t) {
        return 0;
    }
    public Manager createManager(Manager m) {
        return null;
    }
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
    public void view() {
        Vector<String> actions = new Vector<>();
        actions.add("View Registrations");
        actions.add("Delete");
        actions.add("Create");
        int actionNum = Util.pickView(actions, "Action");
        if (actionNum == 1) {
            // System.out.println("Add");
        } else {
            if (actionNum == 2) {
                System.out.println("Delete");
            } else {
                System.out.println("Create");
            }
        }
    }
}

