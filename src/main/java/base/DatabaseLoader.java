package base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CourseRepository repository;
    private final PostRepository postRepository;

    @Autowired
    public DatabaseLoader(PostRepository postRepository, CourseRepository repository) {
        this.postRepository = postRepository;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        ArrayList<Course> sampleCourseList = new ArrayList<>();
        sampleCourseList.add(new Course("CPE", "101", "Fundamentals of Computer Science I"));
        sampleCourseList.add(new Course("CPE", "102", "Fundamentals of Computer Science II"));
        sampleCourseList.add(new Course("CPE", "103", "Fundamentals of Computer Science III"));

        this.repository.save(sampleCourseList);

        ArrayList<Post> samplePostList = new ArrayList<>();
        samplePostList.add(new Post("Testing if this works!!!!"));

        this.postRepository.save(samplePostList);

    }
}
