import java.lang.*;
import java.util.Objects;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.T;

public abstract class Person implements Comparable, Viewable, Interactive {
    private String id;
    private String name;
    private String password;

    public Person() {
		this.id = null;
		this.password = null;
		this.name = null;
	}

	public Person(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
    public String getId() {
        return id;
    }
    public void setId(String id) {
    	this.id = id;
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
        this.password = password;
    }

    public String toString() {
        return "Name: " + this.name + " Id " + this.id;
    }
    
    public boolean equals(Object other) {
    	if (other == null) return false;
		if (other == this) return true;
		if (!(other instanceof Person)) return false;
		Person pp = (Person) other;
		return Objects.equals(this.name, pp.name) && Objects.equals(this.id, pp.id) && Objects.equals(this.password, pp.password);
    	
    }

    public int compareTo(Object other) {
        Person p = (Person)other;
        if(this.name.compareTo(p.name) == 0) {
        	return this.name.compareTo(p.name);
        }
        else return this.name.compareTo(p.name);
    }

    @Override
    public Person create(Person s) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        s.setName(sc.next());

        System.out.println("Enter password: ");
        s.setPassword(Util.hashIt(sc.next()));

        sc.close();

        return s;
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        Person s = null;

        System.out.println("Enter id: ");
        String id = sc.next();

        try {
            s = Storage.getPerson(id);
            System.out.println("Enter desired name: ");
            String name = sc.next();
            s.setName(name);
            System.out.println("Enter desired password: ");
            String password = sc.next();
            s.setPassword(Util.hashIt(password));
        } catch (UserNotFoundException e) {
            System.out.println("Wrong id");
        }

        sc.close();
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id: ");
        String id = sc.next();

        Storage.removePerson(id);

        sc.close();
    }
}

