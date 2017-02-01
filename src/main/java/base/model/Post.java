package base.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class Post implements Serializable {

    private Long id;
    private String title;
    private String post;

    public Post() {
    }

    public Post(String title, String post) {
        this.title = title;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}