package base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("{id}/comments")
    public Course postComment(@PathVariable long id, @RequestBody Comment comment){
        Course course = courseRepository.findCourse(id);
        if (course == null) {
            System.out.println("Null");
            return null;
        } else {
            course.addComment(comment);
            System.out.println("Comment: " + comment.getComment());
            return courseRepository.save(course);
        }
    }

    @PutMapping("{id}/comments/{commentId}")
    public Course putComment(@PathVariable long id, @PathVariable long commentId, @RequestBody Comment comment){
        Course course = courseRepository.findCourse(id);
        if (course == null) {
            System.out.println("Null");
            return null;
        } else {
            course.putComment( (int) commentId, comment);
            System.out.println("Comment: " + comment.getComment());
            return courseRepository.save(course);
        }
    }

    @GetMapping("{id}/comments")
    public List<Comment> getComments(@PathVariable long id){
        Course course = courseRepository.findCourse(id);
        if (course == null) {
            System.out.println("Null");
            return null;
        } else {
            return courseRepository.save(course).getComments();
        }
    }

    @GetMapping("{id}/comments/{commentId}")
    public Comment getComment(@PathVariable long id, @PathVariable long commentId){
        Course course = courseRepository.findCourse(id);
        if (course == null) {
            System.out.println("Null");
            return null;
        } else {
            return courseRepository.save(course).getComments().get((int)commentId);
        }
    }


    @DeleteMapping("{id}/comments/remove/{commentId}")
    public Course deleteComment(@PathVariable long id, @PathVariable long commentId){
        Course course = courseRepository.findCourse(id);
        if (course == null) {
            System.out.println("Null");
            return null;
        } else {

            course.removeComment(commentId);
            return courseRepository.save(course);
        }
    }

}
