package base;

import javax.persistence.*;
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
    private int likes;

    public Post() {

    }

    public Post(User author, String message) {
        this.author = author;
        this.message = message;
        this.timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        this.likes = 0;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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