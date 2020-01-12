package ru.ifmo.webtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.webtest.db.entity.CourseEntity;
import ru.ifmo.webtest.service.CoursesService;

import java.util.List;

@RestController
public class MainController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final CoursesService coursesService;

    public MainController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index.html");
        return view;
    }

    @GetMapping("/courses")
    public List<CourseEntity> allCourses() {
        return coursesService.getAllCourses();
    }

    @PostMapping("/courses/add")
    public CourseEntity addCourse(@RequestBody CourseEntity courseEntity) {
        coursesService.addCourse(courseEntity);

        return courseEntity;
    }

    @DeleteMapping("/courses/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") Integer courseId) {
        try {
            coursesService.deleteCourse(courseId);
        }
        catch (Exception e) {
            LOGGER.error("Error deleting course", e);
            return String.format("{\"result\":\"success\", \"error\": \"%s\"}", e.getMessage());
        }

        return "{\"result\":\"success\", \"error\": \"\"}";
    }
}
