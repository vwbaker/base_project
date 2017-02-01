package base.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class Course implements Serializable {


    private Long id;
    private String prefix;
    private String number;
    private String title;

    public Course (){};

    public Course(String prefix, String number, String title) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
