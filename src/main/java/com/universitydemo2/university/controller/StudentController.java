package com.universitydemo2.university.controller;

import com.universitydemo2.university.entity.Student;
import com.universitydemo2.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/Products")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String getProducts(Model model){

        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student/index";
    }

}
