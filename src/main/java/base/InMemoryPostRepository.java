package base;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryPostRepository implements PostRepository {
  private static AtomicLong counter = new AtomicLong();

  private final ConcurrentMap<Long, Post> posts = new ConcurrentHashMap<Long, Post>();

  @Override
  public Iterable<Post> findAll() {
    return this.posts.values();
  }

  @Override
  public Post save(Post posts) {
    Long id = posts.getId();
    if (id == null) {
      id = counter.incrementAndGet();
      posts.setId(id);
    }
    this.posts.put(id, posts);

    return posts;
  }

  @Override
  public List<Post> save(List<Post> posts) {
    for (Post p : posts) {
      save(p);
    }
    return posts;
  }

  @Override
  public Post findPost(Long id) {
    return this.posts.get(id);
  }

  @Override
  public Post deletePost(Long id) {
    return this.posts.remove(id);
  }
}
