package ru.ifmo.webtest.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ifmo.webtest.db.entity.CourseEntity;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    // https://docs.spring.io/spring-data/jpa/docs/2.2.3.RELEASE/reference/html/#jpa.query-methods.query-creation
    List<CourseEntity> findByTitle(String title);
    List<CourseEntity> findByDurationLessThan(short duration);
    List<CourseEntity> findByPriceLessThan(double price);
    @Query("select c from CourseEntity c left join TeacherEntity t on t.course = c where t is null")
    List<CourseEntity> findCoursesWithoutTeacher();
}
