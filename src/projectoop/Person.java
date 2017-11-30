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

    public void setPassword(String password) {
        this.password = Util.hashIt(password);
    }

    @Override
    public Person create(Person s) {
        Scanner sc = Util.getReadingScanner();

        System.out.println("Enter name: ");
        s.setName(sc.next());

        System.out.println("Enter password: ");
        s.setPassword(sc.next());

        return s;
    }

    @Override
    public void update() {
        Scanner sc = Util.getReadingScanner();

        System.out.println("Enter desired name: ");
        String name = sc.next();
        setName(name);
        System.out.println("Enter desired password: ");
        String password = sc.next();
        setPassword(Util.hashIt(password));
    }

}

