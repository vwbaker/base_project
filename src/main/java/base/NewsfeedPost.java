package base;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("newsfeed")
public class NewsfeedPost extends Post {
    
    private String postContent;
    private String[] tags;
    private Comment[] comments;

    public NewsfeedPost() {

    }

    public NewsfeedPost(User author, String message, String[] tags) {
        super(author,message);
        this.tags = tags;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Comment[] getComments() {
        return comments;
    }

}