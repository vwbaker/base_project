package base.Post;

import base.User.User;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "PostTable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ptype", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("post")
public class Post implements Serializable, Comparable<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String timeStamp;
    private User author;
    private String message;

    public Post() {

    }

    public Post(User author, String message) {
        this.author = author;
        this.message = message;
        this.timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
    }

    public String getTimeStamp() {
    	return timeStamp;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
	public int compareTo(Post o) {
		return timeStamp.compareTo(o.getTimeStamp());
	}

}