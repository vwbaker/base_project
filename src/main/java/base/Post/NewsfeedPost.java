package base.Post;

import base.User.User;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Column;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("newsfeed")
public class NewsfeedPost extends Post {
    
    //do we need postContent? we have message
    private String postContent;
    private String tags;
    private int likes;
    //store comment ids instead?
    private ArrayList<Comment> comments;

    public NewsfeedPost() {

    }

    public NewsfeedPost(User author, String message, String tags) {
        super(author,message);
        this.tags = tags;
        this.likes = 0;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment c) {
        comments.add(c);
    }

}