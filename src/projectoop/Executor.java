package projectoop;

import java.io.Serializable;
import java.util.Vector;

public class Executor extends Employee implements Serializable {

    Vector<Order> orders = new Vector<Order>();


    public Executor() {
        super();
    }


    public Executor(String name, String email, String surname, String phoneNumber, boolean isWorking,
                    boolean isTeaching, Vector<Order> orders) {
        super(name, email, surname, phoneNumber, isWorking, isTeaching);
        this.orders = orders;
    }


    public Vector<Order> getOrders() {
        return orders;
    }


    public void setOrders(Vector<Order> orders) {
        this.orders = orders;
    }


    public String viewOrders() {
        return "Executor [orders=" + orders + "]";
    }


    public void acceptOrder(Order newOrder) {
        if (newOrder.isDone == false) {
            orders.add(newOrder);
        }
    }


    public void setSalary(double bonus) {
        if (orders.size() != 0) {
            super.setSalary(super.getSalary() + orders.size() * bonus);
        }
    }

}
