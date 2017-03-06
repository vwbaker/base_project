package base.post;

import base.security.CurrentUser;
import base.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ArrayList<Post> listAll() {
        ArrayList<Post> posts = new ArrayList<>();
        postRepository.findAllToCurrentUser().forEach(posts::add);
        return posts;
    }

    // Must be authenticated to Post
    @PostMapping
    public Post create(@CurrentUser User currentUser, @RequestBody Post post) {
        post.setCreatedBy(currentUser);
        post.setLastUpdated(new Date());
        post.setCreateAt(new Date());
        return postRepository.save(post);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        postRepository.delete(id);
    }

    @PutMapping("{id}")
    public Post update(@PathVariable Long id, @RequestBody Post reqPost) {
        Post post = postRepository.findOne(id);
        if (post == null) {
            return null;
        } else {
            post.setLastUpdated(new Date());
            post.setMessage(reqPost.getMessage());
            return postRepository.save(post);
        }
    }
}
