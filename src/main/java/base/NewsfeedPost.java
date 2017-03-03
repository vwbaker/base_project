package base;

<<<<<<< HEAD

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("newsfeed")
=======
>>>>>>> c72673220e80db08818a9575f498a32682df4b8e
public class NewsfeedPost extends Post {
    private String postContent;
    private String tags;
    private Comment[] comments;

    public NewsfeedPost() {
        super();
        this.postContent = null;
        this.tags = null;
        comments = null;
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

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}