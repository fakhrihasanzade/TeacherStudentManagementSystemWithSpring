package com.management.TeacherStudentService.controller;

import com.management.TeacherStudentService.entity.Teacher;
import com.management.TeacherStudentService.service.CommonService;
import com.management.TeacherStudentService.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    private final CommonService<Teacher> common;

    private final TeacherService teacher;

    public TeacherController(CommonService<Teacher> common, TeacherService teacher) {
        this.common = common;
        this.teacher = teacher;
    }

    @GetMapping("/teachers/get-all")
    public List<Teacher> getAll() {
        return common.getAll();
    }

    @GetMapping("/teacher/{id}")
    public Object getById(@PathVariable Long id) {
        return common.getById(id);
    }

    @DeleteMapping("/teacher/delete/{id}")
    public void delete(@PathVariable Long id) {
        common.delete(id);
    }

    @PostMapping("/teacher/save")
    public void save(@RequestBody Teacher obj) {
        common.save(obj);
    }

    @PutMapping("/teacher/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Teacher obj) {
        common.update(id, obj);
    }

    @GetMapping("/teacher/getBySubject/{subject}")
    List<Teacher> getBySubject(@PathVariable String subject) {
        return teacher.getBySubject(subject);
    }

    @GetMapping("/teacher/getByUpperExperience/{exp}")
    List<Teacher> getByUpperExperience(@PathVariable Integer exp) {
        return teacher.getByUpperExperience(exp);
    }

    @GetMapping("/teacher/salary/{lowerSalary}/{upperSalary}")
    List<Teacher> getBySalaryInterval(@PathVariable Double lowerSalary, @PathVariable Double upperSalary) {
        return teacher.getBySalaryInterval(lowerSalary, upperSalary);
    }

}
