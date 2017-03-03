package base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class Controller {

    @Autowired
    ContentDatabase postRepository;

    @Autowired
    private ContentController contentController;

    @GetMapping
    public ArrayList<Post> handleGetAll() {
        return contentController.getAllPosts();
    }
    
    @PostMapping
    public Post handleNewPostRequest(@RequestBody NewsfeedPost input) {
        User user = new User("John Doe","jdoe@calpoly.edu");
        NewsfeedPost np = new NewsfeedPost(user, input.getMessage(), input.getTags());
        if(!contentController.newPost(np)) { //if new post could not be made null is returned
            np = null;
        }
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

