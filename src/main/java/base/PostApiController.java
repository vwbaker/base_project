package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        return postRepository.save(new Post(input.getMessage()));
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
            post.setMessage(input.getMessage());
            return postRepository.save(post);
        }
    }

}
