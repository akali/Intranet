/**
 */
public abstract class Employee extends Person {
    /**
     */
    private int salary;
    
    public Employee(String id, String password, String name, int salary) {
		super(id, password, name);
		this.salary = salary;
	}

    public Employee(){}


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
    	this.salary = salary;
    }
    public String toString() {
	    return "\n" + super.toString() + "\nSalary: " + this.salary;
	}
}

