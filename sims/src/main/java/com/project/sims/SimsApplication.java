package com.project.sims;

import com.project.sims.student.entity.Course;
import com.project.sims.student.entity.Student;
import com.project.sims.student.repository.CourseRepository;
import com.project.sims.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SimsApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        //Creating student and courses entities which will be preloaded on app boot up
        Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com",2,40.00);
        studentRepository.save(student1);

        Course course1 = new Course("OPERATING SYSTEMS","Y","100");
        courseRepository.save(course1);

        Course course2 = new Course("DATABASE","Y","100");
        courseRepository.save(course2);

        Course course3 = new Course("USER DESIGN","Y","100");
        courseRepository.save(course3);

        Course course4 = new Course("CLOUD COMPUTING","Y","100");
        courseRepository.save(course4);

        Course course5 = new Course("BIG DATA ANALYTICS","Y","100");
        courseRepository.save(course5);
    }

}
