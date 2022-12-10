package com.project.sims.student.service;

import com.project.sims.student.entity.Course;
import com.project.sims.student.entity.Student;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);
}
