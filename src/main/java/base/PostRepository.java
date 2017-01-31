package base;

import java.util.List;

public interface PostRepository {
  
  Iterable<Post> findAll();

  Post save(Post post);

  List<Post> save(List<Post> post);

  Post findPost(Long id);

  Post deletePost(Long id);
  
}
