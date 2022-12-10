package com.project.sims.student.controller;

import com.project.sims.login.Role;
import com.project.sims.login.User;
import com.project.sims.login.UserRepository;
import com.project.sims.student.entity.Student;
import com.project.sims.student.repository.StudentRepository;
import com.project.sims.student.service.CourseService;
import com.project.sims.student.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class StudentController {
    private StudentService studentService;

    private CourseService courseService;

    private UserRepository userRepo;

    public StudentController(StudentService studentService, CourseService courseService, UserRepository userRepo) {
        super();
        this.studentService = studentService;
        this.courseService = courseService;
        this.userRepo = userRepo;
    }

    // handler method to handle list students
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "admin/admin_studentlist";
    }

    //handler to add new student
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "admin/admin_createstudent";
    }

    //handler to save new student
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        User newUser= new User(student.getEmail(),"student",Role.STUDENT);
        userRepo.save(newUser);
        return "redirect:/students";
    }

    //handler to edit student
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "admin/admin_editstudent";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setNoOfCourses(student.getNoOfCourses());
        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //handler for deleting student
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    //handler for getting fees
    @GetMapping("/student/getFees")
    public String getFees(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userNm=auth.getName();
        Student currentStudent=studentService.getStudentByEmail(userNm);
        int coursesTaken=currentStudent.getNoOfCourses();
        String feeCalculated=(coursesTaken*100)+"";
        model.addAttribute("feeCalculated",feeCalculated);
        model.addAttribute("student",studentService.getStudentByEmail(userNm));
        return "student/student_fees";
    }

    //handler for student profile
    @GetMapping("/student/profile")
    public String my_profile(Model model, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userNm=auth.getName();
        String details=auth.getDetails().toString();
        model.addAttribute("student",studentService.getStudentByEmail(userNm));
        Student st1=studentService.getStudentByEmail(userNm);
        return "student/student_profile";
    }

    //handler for viewing courses in student login
    @GetMapping("/student/courses")
    public String viewCourses(Model model){
        model.addAttribute("courses",courseService.getAllCourses());
        return "student/student_courses";
    }

    //handler for attendance
    @GetMapping("student/getAttendance")
    public String viewPendingAttendance(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userNm=auth.getName();
        Student currentStudent=studentService.getStudentByEmail(userNm);
        double currentAttendance=currentStudent.getAttendance();
        double requiredPercentage=70.00;
        double pendingAttendance=requiredPercentage-currentAttendance;
        model.addAttribute("attendance",pendingAttendance);
        model.addAttribute("student",studentService.getStudentByEmail(userNm));
        return "student/student_attendance";
    }

}
