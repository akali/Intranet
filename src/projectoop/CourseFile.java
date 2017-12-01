package projectoop;

import java.io.Serializable;
import java.lang.*;
import java.util.Date;

public class CourseFile implements Serializable {
    private String title;
    private String desc;
    private Date addDate;
    public String pretty() {
        return toString();
    }

    public CourseFile(String title, String desc, Date addDate) {
        this.title = title;
        this.desc = desc;
        this.addDate = addDate;
    }

    public static CourseFile create() {
        String title = Util.askGet(Util.getReadingScanner(), "Enter title");
        String desc = Util.askGet(Util.getReadingScanner(), "Enter description");
        return new CourseFile(title, desc, new Date());
    }

    @Override
    public String toString() {
        return "CourseFile{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", addDate=" + addDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseFile that = (CourseFile) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        return addDate != null ? addDate.equals(that.addDate) : that.addDate == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        return result;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}

