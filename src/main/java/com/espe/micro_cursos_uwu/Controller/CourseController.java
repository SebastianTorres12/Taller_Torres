package com.espe.micro_cursos_uwu.Controller;

import com.espe.micro_cursos_uwu.Entity.Course;
import com.espe.micro_cursos_uwu.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // get all courser
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    // Get course by id
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    // Create a new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // Delete course by id
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@RequestBody Course course, @PathVariable("id") Long id){
        return courseService.updateCourse(course, id);
    }
}
