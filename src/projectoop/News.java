package projectoop;

import java.io.Serializable;
import java.util.Date;

import users.Manager;

public class News implements Serializable {

    private String title;
    private String text;
    private Date date;
    private Manager sender;


    public News() {
    }

    ublic String

    getTitle() {
        return title;
    }


    public void setTitle(String title)

    this.title=title;
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


    public boolean equals(Object obj) {
        News news = (News) obj;
        return (news.getText().equals(this.text) && news.getTitle().equals(this.title) && news.getSender().equals(this.sender) && news.getDate().equals(this.date));
    }


    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nText: %s\nSender: %s\nDate: %s", title, text, sender.getName() + sender.getLastName(), date);
    }

}

