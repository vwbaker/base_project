package base.Post;
import base.User.User;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comment")

public class Comment extends Post {
	//store id of parent instead?
    private Post parent;
}