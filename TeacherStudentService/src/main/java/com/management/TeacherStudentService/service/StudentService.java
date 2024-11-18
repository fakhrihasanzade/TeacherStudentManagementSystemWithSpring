package com.management.TeacherStudentService.service;

import com.management.TeacherStudentService.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getByMajor(String major);

    List<Student> getByCourseYear(Short courseYear);

    List<Student> getByGpaInterval(Double gpa1, Double gpa2);

}
