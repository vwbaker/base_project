package base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.stereotype.Controller;

@Controller
public class ContentController {

	@Autowired
    ContentDatabase postRepository;

	public ContentController() {
	}

	public ArrayList<Post> getAllPosts() {
		ArrayList<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(post -> posts.add(post));
        return posts;
	}

	public boolean newPost(Post post) {
		return postRepository.save(post) != null;
	}
		
}