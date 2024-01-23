package com.universitydemo2.university.dao;

import com.universitydemo2.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {



}