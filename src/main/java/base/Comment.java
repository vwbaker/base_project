package base;

public class Comment extends Post {
    private Post parent;
    private String author;

    public String getAuthor() {
        return author;
    }
}
