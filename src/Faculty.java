package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.*;


public class Faculty implements Serializable {
    public static String facultyName;
    private Vector<Teacher> listOfTeachers = new Vector<Teacher>();
    private Vector<Student> listOfStudents = new Vector<Student>();
    private Vector<Specialty> listOfSpecialties = new Vector<Specialty>();    
    private static Teacher dean;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listOfSpecialties == null) ? 0 : listOfSpecialties.hashCode());
		result = prime * result + ((listOfStudents == null) ? 0 : listOfStudents.hashCode());
		result = prime * result + ((listOfTeachers == null) ? 0 : listOfTeachers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (listOfSpecialties == null) {
			if (other.listOfSpecialties != null)
				return false;
		} else if (!listOfSpecialties.equals(other.listOfSpecialties))
			return false;
		if (listOfStudents == null) {
			if (other.listOfStudents != null)
				return false;
		} else if (!listOfStudents.equals(other.listOfStudents))
			return false;
		if (listOfTeachers == null) {
			if (other.listOfTeachers != null)
				return false;
		} else if (!listOfTeachers.equals(other.listOfTeachers))
			return false;
		return true;
	}

	public Faculty(Vector<Teacher> listOfTeachers, Vector<Student> listOfStudents,
			Vector<Specialty> listOfSpecialties) {
		super();
		this.listOfTeachers = listOfTeachers;
		this.listOfStudents = listOfStudents;
		this.listOfSpecialties = listOfSpecialties;
	}

	public Faculty() {
		super();
	}

	public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    
    public Person getDean() {
        return dean;
    }

    public void setDean(Person dean) {
        this.dean = (Teacher) dean;
    }

    public Collection getListOfTeachers() {
        return listOfTeachers;
    }

    public void setTeacher(Teacher teacher) {
    	listOfTeachers.add(teacher);
    }
    public static void setStudent(Faculty f, Student s) {
    	f.listOfStudents.add(s);
    }
    public static void deleteStudent(Faculty f, Student s) {
    	f.listOfStudents.remove(s);
    }
}
