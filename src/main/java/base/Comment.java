package base;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comment")

public class Comment extends Post {
    private Post parent;
    private String author;
}