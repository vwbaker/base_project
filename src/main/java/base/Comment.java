package base;

import javax.persistence.*;
@Entity
@DiscriminatorValue("comment")  

public class Comment extends Post {
    private Post parent;
    private String author;
}