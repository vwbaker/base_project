
/**
 * Created by miguel on 1/31/17.
 */

package base.data;

import base.model.Post;
import java.util.List;

public interface PostRepository {

    Iterable<Post> findAll();

    Post save(Post course);

    List<Post> save(List<Post> courses);

    Post find(Long id);

    Post delete(Long id);

}
