package base;

public class NewsfeedPost extends Post {
    private String postContent;
    private String tags;
    private Long id;

    private Comment[] comments;

    public String getPostContent() {
        return postContent;
    }

    public String getTags() {
        return tags;
    }

    public Long getId() {
        return id;
    }

    public Comment[] getComments() {
        return comments;
    }
}