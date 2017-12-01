package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.Scanner;

public abstract class Person implements Serializable, Viewable, Interactive {
    protected String login;
    protected String name;
    protected String password;

    public Person() {}

	public Person(String login, String password, String name) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
	}

	public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
    	this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    	this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = projectoop.Util.hashIt(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (login != null ? !login.equals(person.login) : person.login != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return password != null ? password.equals(person.password) : person.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public Person create(Person s) {
        Util.Scanner sc = Util.getReadingScanner();

        System.out.println("Enter name: ");
        s.setName(sc.next());

        System.out.println("Enter password: ");
        s.setPassword(sc.next());

        return s;
    }

    @Override
    public void update() {
        Util.Scanner sc = Util.getReadingScanner();

        System.out.println("Enter desired name: ");
        String name = sc.next();
        setName(name);
        System.out.println("Enter desired password: ");
        String password = sc.next();
        setPassword(projectoop.Util.hashIt(password));
    }

}

