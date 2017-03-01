package base;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public Post create(@RequestBody Post input) {
      return postRepository.save(new Post(input.getMessageBody()));
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
      postRepository.delete(id);
  }

  @PutMapping("{id}")
  public Post update(@PathVariable Long id, @RequestBody Post input) {
      Post post = postRepository.findOne(id);
      if (post == null) {
          return null;
      } else {
          post.setMessageBody(input.getMessageBody());
          return postRepository.save(post);
      }
  }
  
}
