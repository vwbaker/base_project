package base;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class Post implements Serializable {


    private Long id;
    private String message;

    public Post (){};

    public Post(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
