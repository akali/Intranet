package projectoop;

import java.io.Serializable;


public abstract class Employee extends Person implements Serializable {
    protected double salary;

    public Employee(String login, String password, String name, double salary) {
        super(login, password, name);
        this.salary = salary;
    }

    public Employee() {}

}