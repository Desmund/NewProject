package Main.Menu;

import java.util.Date;

/**
 * Created by Denis on 19.09.2014.
 */
public class BaseWork {
    String name;
    String theme;
    String group;
    int mark;
    Date date;
    byte rating;

    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public String getGroup() {
        return group;
    }

    public int getMark() {
        return mark;
    }

    public Date getDate() {
        return date;
    }

    public byte getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public BaseWork(String name,String theme,String group,int mark){
        this.group=group;
        this.mark=mark;
        this.name=name;
        this.theme=theme;
        this.date = new Date();
        this.date.getTime();
        this.rating = 0;
    }
}
