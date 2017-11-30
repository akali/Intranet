package projectoop;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class News implements Serializable, Comparable<News> {
    private String title;
    private String text;
    private Date date;
    private Manager sender;

    public News(String title, String text, Date date, Manager sender) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", sender=" + sender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (text != null ? !text.equals(news.text) : news.text != null) return false;
        if (date != null ? !date.equals(news.date) : news.date != null) return false;
        return sender != null ? sender.equals(news.sender) : news.sender == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Manager getSender() {
        return sender;
    }

    public void setSender(Manager sender) {
        this.sender = sender;
    }

    @Override
    public int compareTo(News o) {
        int compare = date.compareTo(o.getDate());
        if (compare == 0) {
            compare = title.compareTo(o.title);
            if (compare == 0) {
                compare = text.compareTo(o.text);
                if (compare == 0) {
                    return sender.compareTo(o.sender);
                }
            }
        }
        return compare;
    }

    public static News create(Manager sender) {
        Scanner sc = Util.getReadingScanner();
        return new News(Util.askGet(sc, "Enter title: "),
                Util.askGet(sc, "Enter text: "),
                new Date(), sender);
    }
}

