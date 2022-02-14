package sams.movielist.model;
import java.io.Serializable;
public class Movie implements Serializable{
    private long id;
    private String name,date,type,duration,description,url;

    public Movie(){}
    public Movie(long id, String name,String date, String type, String duration,String description, String url ){
        super();
        this.id=id;
        this.name=name;
        this.date=date;
        this.type=type;
        this.duration=duration;
        this.description=description;
        this.url=url;
    }
    public Movie(String name,String date, String type, String duration,String description, String url ){
        super();
        this.name=name;
        this.date=date;
        this.type=type;
        this.duration=duration;
        this.description=description;
        this.url=url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
