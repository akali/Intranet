import java.lang.*;
import java.util.Objects;

public abstract class Person implements Comparable, Viewable{
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
}

