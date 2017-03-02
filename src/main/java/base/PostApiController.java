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
      postRepository.findAll().forEach(post -> posts.add(post));
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
}
