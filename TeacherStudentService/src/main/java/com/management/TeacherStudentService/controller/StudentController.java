package com.management.TeacherStudentService.controller;

import com.management.TeacherStudentService.entity.Student;
import com.management.TeacherStudentService.entity.Teacher;
import com.management.TeacherStudentService.service.CommonService;
import com.management.TeacherStudentService.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final CommonService<Student> common;

    private final StudentService student;

    public StudentController(CommonService<Student> common, StudentService student) {
        this.common = common;
        this.student = student;
    }

    @GetMapping("/students/get-all")
    public List<Student> getAll() {
        return common.getAll();
    }

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable Long id) {
        return common.getById(id);
    }

    @DeleteMapping("/student/delete/{id}")
    public void delete(@PathVariable Long id) {
        common.delete(id);
    }

    @PostMapping("/student/save")
    public void save(@RequestBody Student obj) {
        common.save(obj);
    }

    @PutMapping("/student/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Student obj) {
        common.update(id, obj);
    }

    @GetMapping("/student/getByMajor/{major}")
    public List<Student> getByMajor(@PathVariable String major) {
        return student.getByMajor(major);
    }

    @GetMapping("/students/getByCourseYear/{courseYear}")
    public List<Student> getByCourseYear(@PathVariable Short courseYear) {
        return student.getByCourseYear(courseYear);
    }

    @GetMapping("/students/{gpa1}/{gpa2}")
    public List<Student> getByGpaInterval(@PathVariable Double gpa1, @PathVariable Double gpa2) {
        return student.getByGpaInterval(gpa1, gpa2);
    }

}
