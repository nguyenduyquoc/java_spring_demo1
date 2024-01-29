package com.universitydemo2.university.controller;

import com.universitydemo2.university.entity.Student;
import com.universitydemo2.university.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/v1/students")
public class StudentController {

    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("")
    public String getProducts(Model model){

        Iterable<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/add")
    public String showFormAddStudent(Model model){
        model.addAttribute("newStudent", new Student());
        return "student/add";
    }

    @PostMapping("/add")
    public String saveStudent(@Valid @ModelAttribute("newStudent") Student newStudent, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "student/add";
        } else {
            studentService.addNewStudent(newStudent);
            return "redirect:/v1/students"; // Chuyển hướng sau khi xử lý
        }

    }

    @GetMapping("/edit")
    public String getStudent (@RequestParam("studentId") Integer id, Model model){
        Optional<Student> student = studentService.findStudentById(id);
        student.ifPresent(value -> model.addAttribute("updateStudent", value));
        return "student/update";
    }

    @PostMapping("/update")
    public String updateStudent (@ModelAttribute("updateStudent") Student updateStudent){
        studentService.updateStudent(updateStudent.getId(), updateStudent);
        return "redirect:/v1/students";
    }

    @GetMapping("/delete/id={id}")
    public String deleteStudent (@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "redirect:/v1/students";
    }

}
