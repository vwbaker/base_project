package base.post;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import base.tag.Tag;
import base.tag.TagRepository;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostApiController {

  @Autowired
  private PostRepository postRepository;
  @Autowired
  private TagRepository tagRepository;

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
    //Remove empty tags
    for (Iterator<String> it = in.getTags().iterator(); it.hasNext();) {
      if (it.next().isEmpty()) {
        it.remove();
      }
    }
    
    // Save the post in the database
    Post newPost = postRepository.save(new Post(in.getMessageBody(), in.getName(), 
      in.getTitle(), in.getLocation(), in.getTags()));
    
    // Add post to tag database for later filtering
    for (String tag : in.getTags()) {
      Tag match = tagRepository.findOne(tag);
      if (match == null) {
        tagRepository.save(new Tag(tag, newPost.getId()));
      } else {
        match.addPost(in.getId());
        tagRepository.save(match);
      }
    }
    
    return newPost;
  }
  
  @GetMapping("filter")
  public List<Post> filter(@RequestBody String filter) {
    List<Long> postIds = tagRepository.findOne(filter).getPosts();
    List<Post> posts = new ArrayList<Post>();
    postRepository.findAll(postIds).forEach(post -> posts.add(0, post));
    return posts;
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
      postRepository.delete(id);
  }
}
