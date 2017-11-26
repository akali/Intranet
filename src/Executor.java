import java.util.TreeSet;

public class Executor extends Employee {
    public Executor(String id, String password, String name, int salary) {
		super(id, password, name, salary);
		// TODO Auto-generated constructor stub
	}
	
    private TreeSet<Order> orders;

    private TreeSet<Order> acceptedOrders;
    
    private static TreeSet<Executor> executors;

    public boolean acceptOrder(Order o) {
        return false;
    }
    public TreeSet<Order> viewOrders() {
        return null;
    }
    public int viewAcceptedOrders() {
        return 0;
    }
}

