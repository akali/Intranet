package projectoop;

/**
 * Created by aqali on 29.11.2017.
 */
public class Order {
    private Employee sender;
    private String message;
    private Type type = Type.PENDING;
    enum Type {
        ACCEPTED, REJECTED, PENDING
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (sender != null ? !sender.equals(order.sender) : order.sender != null) return false;
        return message != null ? message.equals(order.message) : order.message == null;
    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sender=" + sender +
                ", message='" + message + '\'' +
                '}';
    }

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order() { }

    public Order(Employee sender, String message) {
        this.sender = sender;
        this.message = message;
    }
    public void accept() {
        setType(Type.ACCEPTED);
    }
    public void reject() {
        setType(Type.REJECTED);
    }
}
