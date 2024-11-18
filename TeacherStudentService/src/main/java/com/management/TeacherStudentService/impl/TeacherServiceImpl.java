package com.management.TeacherStudentService.impl;

import com.management.TeacherStudentService.entity.Teacher;
import com.management.TeacherStudentService.repository.TeacherRepository;
import com.management.TeacherStudentService.service.CommonService;
import com.management.TeacherStudentService.service.TeacherService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService, CommonService<Teacher> {

    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @Override
    public Teacher getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Teacher obj) {
        repository.save(obj);
    }

    @Override
    public void update(Long id, Teacher obj) {

        Teacher foundedTeacher = repository.findById(id).orElseThrow();
        foundedTeacher.setFullName(obj.getFullName());
        foundedTeacher.setSalary(obj.getSalary());
        foundedTeacher.setExperience(obj.getExperience());
        foundedTeacher.setEmail(obj.getEmail());
        foundedTeacher.setPassword(obj.getPassword());
        foundedTeacher.setSubject(obj.getSubject());
        foundedTeacher.setAge(obj.getAge());
        repository.save(foundedTeacher);

    }

    @Override
    public List<Teacher> getBySubject(String subject) {

        List<Teacher> teachers = new ArrayList<>();

        for (Teacher t : repository.findAll()) {
            if (t.getSubject().equals(subject)) {
                teachers.add(t);
            }
        }

        return teachers;
    }

    @Override
    public List<Teacher> getByUpperExperience(Integer exp) {

        List<Teacher> teachers = new ArrayList<>();

        for (Teacher t : repository.findAll()) {
            if (t.getExperience().equals(exp)) {
                teachers.add(t);
            }
        }

        return teachers;
    }

    @Override
    public List<Teacher> getBySalaryInterval(Double lowerSalary, Double upperSalary) {

        List<Teacher> teachers = new ArrayList<>();

        for (Teacher t : repository.findAll()) {
            if (t.getSalary() > lowerSalary && t.getSalary() < upperSalary) {
                teachers.add(t);
            }
        }

        return teachers;
    }
}
