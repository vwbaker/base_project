package co.cognized.apps.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CourseRepository repository;

    @Autowired
    public DatabaseLoader(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Course> sampleCourseList = new ArrayList<>();
        sampleCourseList.add(new Course("CPE", "101", "Fundamentals of Computer Science"));
        sampleCourseList.add(new Course("CPE", "102", "Fundamentals of Computer Science"));
        sampleCourseList.add(new Course("CPE", "103", "Fundamentals of Computer Science"));

        this.repository.save(sampleCourseList);
    }
}
