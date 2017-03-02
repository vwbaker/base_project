package base;

public class SignedOnUser {
    private Long userId;
    private String name;
    private String contact;
    private Post[] posts;

    public SignedOnUser() {
        this.userId = null;
        this.name = null;
        this.contact = null;
        this.posts = null;
    }

    public SignedOnUser(Long id, String name, String contact, Post[] posts) {
        this.userId = id;
        this.name = name;
        this.contact = contact;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }
}
