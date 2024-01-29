package com.universitydemo2.university.dao;

import com.universitydemo2.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {




}