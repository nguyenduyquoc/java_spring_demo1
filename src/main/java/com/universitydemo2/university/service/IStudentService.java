package com.universitydemo2.university.service;

import com.universitydemo2.university.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IStudentService {
    List<Student> getAllStudent();

    void addNewStudent(Student student);

    Optional<Student> findStudentById (Integer id);

    void updateStudent(Integer id, Student student);

    void deleteStudent(Integer id);

}
