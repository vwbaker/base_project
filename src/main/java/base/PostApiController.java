package base;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostApiController {

  @Autowired
  private PostRepository postRepository;

  @GetMapping
  public ArrayList<Post> listAll() {
      ArrayList<Post> posts = new ArrayList<>();
      postRepository.findAll().forEach(post -> posts.add(0, post));
      return posts;
  }

  @GetMapping("{id}")
  public Post find(@PathVariable Long id) {
      return postRepository.findOne(id);
  }

  @PostMapping
  public Post create(@RequestBody Post in) {
      return postRepository.save(new Post(in.getMessageBody(), in.getName(), 
        in.getTitle(), in.getLocation(), in.getTags()));
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
      postRepository.delete(id);
  }

  @PutMapping("{id}")
  public Post update(@PathVariable Long id, @RequestBody Post in) {
      Post post = postRepository.findOne(id);
      if (post == null) {
          return null;
      } else {
          post.setMessageBody(in.getMessageBody());
          post.setName(in.getName());
          post.setTitle(in.getTitle());
          post.setLocation(in.getLocation());
          post.setTags(in.getTags());
          return postRepository.save(post);
      }
  }
}
