package com.universitydemo2.university.service;

import com.universitydemo2.university.dao.IStudentRepository;
import com.universitydemo2.university.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Integer id, Student student) {
        Optional<Student> existedStudent = studentRepository.findById(id);
        if(existedStudent.isPresent()){
            Student student1 = existedStudent.get();
            student1.setFirst_name(student.getFirst_name());
            student1.setLast_name(student.getLast_name());
            student1.setEmail(student.getEmail());

            studentRepository.save(student1);
        } else {
            student.setId(id);
            studentRepository.save(student);
        }
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
