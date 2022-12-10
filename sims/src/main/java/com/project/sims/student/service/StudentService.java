package com.project.sims.student.service;

import com.project.sims.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student getStudentByEmail(String email);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);


}
