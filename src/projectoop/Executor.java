package projectoop;

import java.io.Serializable;
import java.util.Vector;

public class Executor extends Employee {
    Vector<Order> orders = new Vector<>();

    public Executor() {
        super();
    }
    public void acceptOrder(Order o) {
        if (o.getType() == Order.Type.PENDING) {
            orders.add(o);
            o.accept();
        }
    }
    public void rejectOrder(Order o) {
        o.reject();
    }

    @Override
    public boolean view() {
        return false;
    }
}
