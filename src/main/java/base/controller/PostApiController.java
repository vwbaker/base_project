package base.controller;

import base.data.PostRepository;
import base.model.Post;
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
    public ArrayList<Post> readAll() {
        ArrayList<Post> posts = new ArrayList<>();
        for(Post p : postRepository.findAll()) {
            posts.add(p);
        }

        return posts;
    }

    @GetMapping("{id}")
    public Post find(@PathVariable Long id) {
        return postRepository.find(id);
    }

    @PostMapping
    public Post create(@RequestBody Post input) {
        return postRepository.save(new Post(input.getTitle(), input.getPost()));
    }

    @DeleteMapping("{id}")
    public Post delete(@PathVariable Long id) {
        return postRepository.delete(id);
    }

    @PutMapping("{id}")
    public Post update(@PathVariable Long id, @RequestBody Post input) {
        Post post = postRepository.find(id);
        if (post == null) {
            return null;
        } else {
            post.setPost(post.getPost());
            return postRepository.save(post);
        }
    }
}