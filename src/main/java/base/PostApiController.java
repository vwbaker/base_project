package base;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostApiController {

  private final PostRepository postRepository;

  public PostApiController(PostRepository postRepository) {
      this.postRepository = postRepository;
  }

  @GetMapping
  public ArrayList<Post> listAll() {
      ArrayList<Post> posts = new ArrayList<>();
      postRepository.findAll().forEach(post -> posts.add(post));
      return posts;
  }

  @GetMapping("{id}")
  public Post find(@PathVariable Long id) {
      return postRepository.findPost(id);
  }

  @PostMapping
  public Post create(@RequestBody Post input) {
      return postRepository.save(new Post(input.getMessageBody()));
  }

  @DeleteMapping("{id}")
  public Post delete(@PathVariable Long id) {
      return postRepository.deletePost(id);
  }

  @PutMapping("{id}")
  public Post update(@PathVariable Long id, @RequestBody Post input) {
      Post post = postRepository.findPost(id);
      if (post == null) {
          return null;
      } else {
          post.setMessageBody(input.getMessageBody());
          return postRepository.save(post);
      }
  }
  
}
