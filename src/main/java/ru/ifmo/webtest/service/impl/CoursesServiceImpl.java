package ru.ifmo.webtest.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.webtest.db.entity.CourseEntity;
import ru.ifmo.webtest.db.repository.CourseRepository;
import ru.ifmo.webtest.service.CoursesService;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    private final CourseRepository courseRepository;

    public CoursesServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void addCourse(CourseEntity courseEntity) {
        courseRepository.save(courseEntity);
    }

    @Override
    @Transactional
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
