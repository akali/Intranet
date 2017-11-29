package projectoop;

import java.lang.*;
import java.util.Vector;

/**
 */
public class Course {
    /**
     */
    private String name;
    /**
     */
    private Teacher teacher;
    /**
     */
    private Vector<Course> preprequesites;
    /**
     */
    private CourseFile courseFiles;
    /**
     */
    private int creditsNumber;
    /**
     */
    private String id;

    /**
     * @return
     */
    public int getCreditsNumber() {
        return 0;
    }

    public CourseFile getCourseFiles() {
        return courseFiles;
    }

    public void setCourseFiles(CourseFile courseFiles) {
        this.courseFiles = courseFiles;
    }

    /**
     * @param creditsNumber
     */
    public void setCreditsNumber(int creditsNumber) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Vector<Course> getPreprequesites() {
        return preprequesites;
    }

    public void setPreprequesites(Vector<Course> preprequesites) {
        this.preprequesites = preprequesites;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

