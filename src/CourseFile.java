import java.lang.*;

/**
 */
public class CourseFile {
    /**
     */
    private String path;

    /**
     */
    private DateTime addDate;

    /**
     */
    private String title;

    /**
     * @return 
     */
    public String getPath() {
        return null;
    }

    /**
     * @param path 
     */
    public void setPath(String path) {
    }

    /**
     * @return 
     */
    public DateTime getAddDate() {
        return null;
    }

    /**
     * @param addDate 
     */
    public void setAddDate(DateTime addDate) {
    }

    /**
     * @return 
     */
    public String getTitle() {
        return null;
    }

    /**
     * @param title 
     */
    public void setTitle(String title) {
    }

    @Override
    public String toString() {
        return "CourseFile{" +
                "path='" + path + '\'' +
                ", addDate=" + addDate +
                ", title='" + title + '\'' +
                '}';
    }

    public String pretty() {
        return toString();
    }
}

