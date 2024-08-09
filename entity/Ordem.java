package entity;

import java.sql.Time;

public class Ordem {
    private int id;
    private String name;
    private String description;
    private Time time;

    public Ordem(int id, String name, String description,Time time){
        setId(id);
        setName(name);
        setDescription(description);
        setTime(time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    
}
