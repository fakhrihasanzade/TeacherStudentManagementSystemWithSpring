package com.management.TeacherStudentService.impl;

import com.management.TeacherStudentService.entity.Student;
import com.management.TeacherStudentService.repository.StudentRepository;
import com.management.TeacherStudentService.service.StudentService;
import com.management.TeacherStudentService.dto.StudentRequestDto;
import com.management.TeacherStudentService.dto.StudentResponceDto;
import com.management.TeacherStudentService.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<StudentResponceDto> getAll() {

        List<StudentResponceDto> students = new ArrayList<>();

        for (Student s : repository.findAll()) {
            students.add(StudentMapper.entityToDto(s));
        }

        return students;
    }

    @Override
    public StudentResponceDto getById(Long id) {

        StudentResponceDto student = StudentMapper
                .entityToDto(repository.findById(id).orElseThrow());

        return student;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(StudentRequestDto obj) {
        Student student = StudentMapper.dtoToEntity(obj);
        repository.save(student);
    }

    @Override
    public void update(Long id, StudentRequestDto obj) {

        Student student = StudentMapper.dtoToEntity(obj);
        Student student1=repository.findById(id).orElseThrow();
        student1.setFullName(student.getFullName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        student1.setGpa(student.getGpa());
        student1.setCourseYear(student.getCourseYear());
        student1.setPassword(student.getPassword());
        student1.setMajor(student.getMajor());
        repository.save(student1);
    }

    @Override
    public List<StudentResponceDto> getByMajor(String major) {
        List<Student> students = new ArrayList<>();

        List<StudentResponceDto> st = new ArrayList<>();

        for (Student s : repository.findAll()) {
            if (s.getMajor().equals(major)) {
                students.add(s);
            }
        }

        for (Student s : students) {
            st.add(StudentMapper.entityToDto(s));
        }

        return st;
    }

    @Override
    public List<StudentResponceDto> getByCourseYear(Short courseYear) {
        List<Student> students = new ArrayList<>();

        List<StudentResponceDto> st = new ArrayList<>();

        for (Student s : repository.findAll()) {
            if (s.getCourseYear().equals(courseYear)) {
                students.add(s);
            }
        }

        for (Student s : students) {
            st.add(StudentMapper.entityToDto(s));
        }

        return st;
    }

    @Override
    public List<StudentResponceDto> getByGpaInterval(Double gpa1, Double gpa2) {
        List<Student> students = new ArrayList<>();
        List<StudentResponceDto> st = new ArrayList<>();
        for (Student s : repository.findAll()) {
            if (s.getGpa() > gpa1 && s.getGpa() < gpa2) {
                students.add(s);
            }
        }

        for (Student s : students) {
            st.add(StudentMapper.entityToDto(s));
        }

        return st;
    }
}
