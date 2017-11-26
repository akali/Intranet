import java.util.HashMap;
import java.util.TreeSet;

public class Teacher extends Employee {
    public Teacher(String id, String password, String name, int salary) {
		super(id, password, name, salary);
		// TODO Auto-generated constructor stub
	}

    private static TreeSet<Teacher> teachers;

    private TreeSet<Course> courses;

    private HashMap<Course, TreeSet<Student>> students;

    
    public void setTeachers(TreeSet<Teacher> teacher) {
    	this.teachers = teachers;
    }
    
    public void setCourses(TreeSet<Course> courses) {
    	this.courses = courses;
    }
    
    public void setStudents(HashMap<Course,TreeSet<Students>> students) {
    	this.students = students;
    }
    
    public TreeSet<Teacher> getTeacher(){
    	return this.teachers;
    }
    public TreeSet<Course> getCourse(){
    	return this.courses;
    }
    public Hashmap<Course, TreeSet<Student>> getStudents(){
    	return this.students;
    }

    public int viewCourses() {
    
        return 0;
    }

    public int manageCourseFiles() {
        return 0;
    }

    public int viewInfoAboutStudents() {
        return 0;
    }

    public void putMark(Course c, Student s, Mark m) {
    }

    public void sendOrder(Order o, Executor e) {
    }

}

