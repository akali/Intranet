package projectoop;

import java.io.Serializable;
import java.util.HashSet;
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
        int num = Util.pickView("action",
                "View orders",
                "View accepted orders",
                "Show my salary",
                "Exit");
        switch (num) {
            case 1:
                viewOrders();
                break;
            case 2:
                viewAcceptedOrders();
                break;
            case 3:
                System.out.println("Salary = " + getSalary());
                break;
            case 4:
                return false;
            default:
                System.out.println("Wrong input");
                break;
        }
        return true;
    }

    private void viewAcceptedOrders() {
        int num = Util.pickView(orders, "order") - 1;
        if (num < 0 || num >= orders.size()) {
            System.out.println("Wrong input");
            return;
        }
        Order pickedOrder = orders.get(num);
        System.out.println(pickedOrder);
    }
    private void viewOrders() {
        Vector<Order> orders = StorageSingletone.getInstance().getOrders();
        int num = Util.pickView(orders, "order") - 1;
        if (num < 0 || num >= orders.size()) {
            System.out.println("Wrong input");
            return;
        }
        Order pickedOrder = orders.get(num);
        System.out.println(pickedOrder);

        num = Util.pickView("action",
                "Accept",
                "Reject",
                "Cancel");
        switch (num) {
            case 1: acceptOrder(pickedOrder); orders.remove(pickedOrder); break;
            case 2: rejectOrder(pickedOrder); orders.remove(pickedOrder); break;
            case 3: return;
            default: System.out.println("Wrong input"); break;
        }
    }
}
