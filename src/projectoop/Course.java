package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.Vector;

public class Course implements Serializable {
    private String name;
    private Teacher teacher;
    private Vector<Course> preprequesites;
    private CourseFile courseFiles;
    private int creditsNumber;
    private String id;
    public int getCreditsNumber() {
        return 0;
    }

    public CourseFile getCourseFiles() {
        return courseFiles;
    }

    public void setCourseFiles(CourseFile courseFiles) {
        this.courseFiles = courseFiles;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (creditsNumber != course.creditsNumber) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (teacher != null ? !teacher.equals(course.teacher) : course.teacher != null) return false;
        if (preprequesites != null ? !preprequesites.equals(course.preprequesites) : course.preprequesites != null)
            return false;
        if (courseFiles != null ? !courseFiles.equals(course.courseFiles) : course.courseFiles != null) return false;
        return id != null ? id.equals(course.id) : course.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (preprequesites != null ? preprequesites.hashCode() : 0);
        result = 31 * result + (courseFiles != null ? courseFiles.hashCode() : 0);
        result = 31 * result + creditsNumber;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}

