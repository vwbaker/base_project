package base.Post;
import base.User.User;
import base.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class Controller {

    @Autowired
    ContentDatabase postRepository;

    @GetMapping
    public ArrayList<Post> handleGetAll() {
        ArrayList<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(post -> posts.add(post));
        return posts;
    }

    
    @GetMapping("{tags}") 
    public ArrayList<Post> handleFilterRequest(@PathVariable String[] tags) {
        ArrayList<Post> posts = new ArrayList<>();
        for(String t: tags) {
            posts.addAll(postRepository.findByTag(t));
        }
        return posts;
    }
    
    @PostMapping
    public Post handleNewPostRequest(@CurrentUser User currentUser, @RequestBody NewsfeedPost input) {
        NewsfeedPost np = new NewsfeedPost(currentUser, input.getMessage(), input.getTags());
        postRepository.save(np);
        return np;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        postRepository.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        postRepository.deleteAll();
    }


    @PutMapping("{id}")
    public Post incrementLike(@PathVariable Long id) {
        NewsfeedPost post = (NewsfeedPost)postRepository.findOne(id);
        if (post == null) {
            return null;
        } else {
            post.setLikes(post.getLikes()+1);
            return postRepository.save(post);
        }
    }

    @PutMapping
    public Post update(@RequestBody NewsfeedPost input) {
        NewsfeedPost post = (NewsfeedPost)postRepository.findOne(input.getId());
        if (post == null) {
            return null;
        } else {
            post.setMessage(input.getMessage());
            post.setLikes(input.getLikes());
            post.setTags(input.getTags());
            return postRepository.save(post);
        }
    }

}

