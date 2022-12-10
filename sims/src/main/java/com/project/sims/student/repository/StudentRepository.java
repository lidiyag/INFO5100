package com.project.sims.student.repository;

import com.project.sims.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    public Student findByEmail(String email);
}
