package projectoop;

import java.util.TreeSet;

public class Manager extends Employee {
    
    public Manager() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return type == manager.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public Manager(String id, String password, String name, int salary) {
		super(id, password, name, salary);
		// TODO Auto-generated constructor stub
	}

	private ManagerType type;
  
    private static TreeSet<Manager> managers;

    public ManagerType getType() {
        return type;
    }
    public void setType(ManagerType type) {
    	this.type = type;
    }
    public boolean approveRegistration(Course c, Student s) {
        return false;
    }
    
    public void assignCourse(Course c, Teacher t) {
    }
    
    public Report createReport() {
        return null;
    }
    
    public void addNews(News n) {
    }
    
    public void removeNews(News n) {
    }

    public TreeSet<Manager> getManagers() {
        return null;
    }

    @Override
    public boolean view() {

        return false;
    }
}

