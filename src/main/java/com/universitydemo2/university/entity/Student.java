package com.universitydemo2.university.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull(message = "First name is required")
    @Size(min = 2, message = "First Name must be at least 2 characters")
    private String first_name;


    @NotNull(message = "Last name is required")
    @Size(min = 2, message = "Last Name must be at least 2 characters")
    private String last_name;


    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;


    public Student(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

}
