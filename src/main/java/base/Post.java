package base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Serializable, Comparable<Post> {

    private String timestamp;
    private SignedOnUser author;
    private String message;
    private int likes;
    private int id;

    public Post() {
        this.author = null;
        this.message = null;
        this.timestamp = null;
        this.likes = 0;
        this.id = 0;
    }

    public Post(SignedOnUser author, String message) {
        this.author = author;
        this.message = message;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        this.likes = 0;
    }

    public String getTimestamp() {
    	return timestamp;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SignedOnUser getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
	public int compareTo(Post o) {
		return timestamp.compareTo(o.getTimestamp());
	}
}
