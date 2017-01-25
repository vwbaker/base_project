package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/course")
public class CourseApiController {

    private final CourseRepository courseRepository;

    public CourseApiController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public ArrayList<Course> listAll() {
        ArrayList<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> courses.add(course));
        return courses;
    }

    @GetMapping("{id}")
    public Course find(@PathVariable Long id) {
        return courseRepository.findCourse(id);
    }

    @PostMapping
    public Course create(@RequestBody Course input) {
        return courseRepository.save(new Course(input.getPrefix(), input.getNumber(), input.getTitle()));
    }

    @DeleteMapping("{id}")
    public Course delete(@PathVariable Long id) {
        return courseRepository.deleteCourse(id);
    }

    @PutMapping("{id}")
    public Course update(@PathVariable Long id, @RequestBody Course input) {
        Course course = courseRepository.findCourse(id);
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
