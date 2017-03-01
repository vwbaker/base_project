package base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Serializable, Comparable<Post> {

    private String timestamp;
    private SignedOnUser author;
    private String message;
    private int likes;

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

    @Override
	public int compareTo(Post o) {
		return timestamp.compareTo(o.getTimestamp());
	}
}
