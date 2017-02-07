package base;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Serializable, Comparable<Post> {

    private Long id;
    private String timestamp;
    private String message;

    public Post (){};

    public Post(String message) {
        this.message = message;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTimestamp() {
    	return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
    	this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	@Override
	public int compareTo(Post o) {
		return timestamp.compareTo(o.getTimestamp());
	}
}
