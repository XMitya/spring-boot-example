package ru.ifmo.webtest.service;

import org.springframework.stereotype.Service;
import ru.ifmo.webtest.db.entity.CourseEntity;

import java.util.List;

@Service
public interface CoursesService {
    List<CourseEntity> getAllCourses();
    void addCourse(CourseEntity courseEntity);
    void deleteCourse(Integer courseId);
}
