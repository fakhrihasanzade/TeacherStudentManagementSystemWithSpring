package com.management.TeacherStudentService.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Teachers")
public class Teacher extends User {

    private Double salary;

    private String subject;

    private Integer experience;


}
