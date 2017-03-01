package base;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@RequestMapping("/course")
public class CourseApiController {

    @Autowired
    private CourseRepository courseRepository;

//    public CourseApiController(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    @GetMapping
    public ArrayList<Course> listAll() {
        ArrayList<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> courses.add(course));
        return courses;
    }

    @GetMapping("{id}")
    public Course find(@PathVariable Long id) {
        return courseRepository.findOne(id);
    }

    @PostMapping
    public Course create(@RequestBody Course input) {
        return courseRepository.save(new Course(input.getPrefix(), input.getNumber(), input.getTitle()));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        courseRepository.delete(id);
    }

    @PutMapping("{id}")
    public Course update(@PathVariable Long id, @RequestBody Course input) {
        Course course = courseRepository.findOne(id);
        if (course == null) {
            return null;
        } else {
            course.setNumber(input.getNumber());
            course.setPrefix(input.getPrefix());
            course.setTitle(input.getTitle());
            return courseRepository.save(course);
        }
    }

}
