package com.management.TeacherStudentService.service;

import com.management.TeacherStudentService.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getBySubject(String subject);

    List<Teacher> getByUpperExperience(Integer exp);

    List<Teacher> getBySalaryInterval(Double lowerSalary, Double upperSalary);

}
