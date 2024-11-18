package com.management.TeacherStudentService.impl;

import com.management.TeacherStudentService.entity.Student;
import com.management.TeacherStudentService.repository.StudentRepository;
import com.management.TeacherStudentService.service.CommonService;
import com.management.TeacherStudentService.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService, CommonService<Student> {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Student obj) {
        repository.save(obj);
    }

    @Override
    public void update(Long id, Student obj) {
        Student findedStudent=repository.findById(id).orElseThrow();
        findedStudent.setFullName(obj.getFullName());
        findedStudent.setAge(obj.getAge());
        findedStudent.setGpa(obj.getGpa());
        findedStudent.setMajor(obj.getMajor());
        findedStudent.setEmail(obj.getMajor());
        findedStudent.setCourseYear(obj.getCourseYear());
    }

    @Override
    public List<Student> getByMajor(String major) {
        List<Student> students=new ArrayList<>();
        for(Student s: repository.findAll()){
            if(s.getMajor().equals(major)){
                students.add(s);
            }
        }
        return students;
    }

    @Override
    public List<Student> getByCourseYear(Short courseYear) {
        List<Student> students=new ArrayList<>();
        for(Student s: repository.findAll()){
            if(s.getCourseYear().equals(courseYear)){
                students.add(s);
            }
        }
        return students;
    }

    @Override
    public List<Student> getByGpaInterval(Double gpa1, Double gpa2) {
        List<Student> students=new ArrayList<>();
        for(Student s: repository.findAll()){
            if(s.getGpa()>gpa1&&s.getGpa()<gpa2){
                students.add(s);
            }
        }
        return students;
    }
}
