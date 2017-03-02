package base;

public class Comment extends Post {
    private Post parent;
    private String author;

    public Comment() {
        super();
        this.parent =  null;
        this.author = null;
    }
}
