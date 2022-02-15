package com.sams.TeachingHome.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long> {
    Optional<StudentModel> findStudentModelById(long id);
}
