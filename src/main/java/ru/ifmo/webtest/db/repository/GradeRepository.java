package ru.ifmo.webtest.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.webtest.db.entity.GradeEntity;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
}
