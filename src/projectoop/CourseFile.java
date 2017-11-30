package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.Date;

public class CourseFile implements Serializable {
    private String path;
    private Date addDate;
    private String title;
    public String pretty() {
        return toString();
    }
}

