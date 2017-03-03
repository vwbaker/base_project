package base;

<<<<<<< HEAD
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comment")

=======
>>>>>>> c72673220e80db08818a9575f498a32682df4b8e
public class Comment extends Post {
    private Post parent;
    private String author;

    public Comment() {
        super();
        this.parent =  null;
        this.author = null;
    }
}
