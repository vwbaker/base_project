package base;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {


    private Long id;
    private String prefix;
    private String number;
    private String title;
    private ArrayList<Comment> comments;
    public Course (){}

    public Course(String prefix, String number, String title) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        this.comments = new ArrayList<Comment>();
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void putComment(long commentId, Comment newComment){
        this.comments.set((int)commentId, newComment);
    }

    public void removeComment(long commentIndex){
        this.comments.remove((int) commentIndex);
    }

    public List<Comment> getComments(){
        return this.comments;
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
