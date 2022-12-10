package com.project.sims.student.controller;

import com.project.sims.student.entity.Course;
import com.project.sims.student.entity.Student;
import com.project.sims.student.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }

    //handler for listing courses
    @GetMapping("/courses")
    public String listCourses(Model model){
        model.addAttribute("courses",courseService.getAllCourses());
        return "admin/admin_courselist";
    }

    //handler for new course
    @GetMapping("/courses/new")
    public String createStudentForm(Model model){
        Course course=new Course();
        model.addAttribute("course",course);
        return "admin/admin_createcourse";
    }

    //handler for adding new course to repo
    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    //handler for editing course
    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model){
        model.addAttribute("course",courseService.getCourseById(id));
        return "admin/admin_editcourse";
    }

    //handler for updating course
    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable Long id,
                                @ModelAttribute("course") Course course,
                                Model model) {

        // get course from database by id
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setId(id);
        existingCourse.setFirstName(course.getFirstName());
        existingCourse.setAvailable(course.getAvailable());
        existingCourse.setFees(course.getFees());

        // save updated course object
        courseService.updateCourse(existingCourse);
        return "redirect:/courses";
    }

    //handler for deleting course
    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }


}
