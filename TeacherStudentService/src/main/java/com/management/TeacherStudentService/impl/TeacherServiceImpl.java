package com.management.TeacherStudentService.impl;

import com.management.TeacherStudentService.dto.TeacherRequestDto;
import com.management.TeacherStudentService.dto.TeacherResponseDto;
import com.management.TeacherStudentService.entity.Teacher;
import com.management.TeacherStudentService.exception.subexception.InvalidIdException;
import com.management.TeacherStudentService.exception.subexception.TeacherNotFoundException;
import com.management.TeacherStudentService.mapper.TeacherMapper;
import com.management.TeacherStudentService.repository.TeacherRepository;
import com.management.TeacherStudentService.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<TeacherResponseDto> getAll() {

        List<TeacherResponseDto> teachers = new ArrayList<>();
        repository.findAll().stream()
                .map(t -> teachers.add(TeacherMapper.entityToDto(t))).toList();

        return teachers;
    }

    @Override
    public TeacherResponseDto getById(Long id) {

        if(id<=0){
            throw new InvalidIdException("Id is not correct");
        }

        TeacherResponseDto findedTeacher =
                TeacherMapper.entityToDto(repository.findById(id)
                        .orElseThrow(()->new TeacherNotFoundException("Teacher is not found")));

        return findedTeacher;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(TeacherRequestDto obj) {
        repository.save(TeacherMapper.dtoToEntity(obj));
    }

    @Override
    public void update(Long id, TeacherRequestDto obj) {
        Teacher teacher = TeacherMapper.dtoToEntity(obj);
        Teacher teacher1=repository.findById(id).orElseThrow();
        teacher1.setFullName(teacher.getFullName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setAge(teacher.getAge());
        teacher1.setExperience(teacher.getExperience());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setPassword(teacher.getPassword());
        teacher1.setSubject(teacher.getSubject());
        repository.save(teacher1);
    }

    @Override
    public List<TeacherResponseDto> getBySubject(String subject) {

        List<TeacherResponseDto> teachers = new ArrayList<>();

        repository.findAll().stream().map(t->{
            if(t.getSubject().equals(subject)){
                teachers.add(TeacherMapper.entityToDto(t));
            }
            return null;
        });

        return teachers;
    }

    @Override
    public List<TeacherResponseDto> getByUpperExperience(Integer exp) {

        List<TeacherResponseDto> teachers = new ArrayList<>();

        repository.findAll().stream().map(t->{
            if(t.getExperience().equals(exp)){
                teachers.add(TeacherMapper.entityToDto(t));
            }
            return null;
        });

        return teachers;
    }

    @Override
    public List<TeacherResponseDto> getBySalaryInterval(Double lowerSalary, Double upperSalary) {

        List<Teacher> teachers = new ArrayList<>();

        for (Teacher t : repository.findAll()) {
            if (t.getSalary() > lowerSalary && t.getSalary() < upperSalary) {
                teachers.add(t);
            }
        }

        List<TeacherResponseDto> teach=new ArrayList<>();

        for (Teacher t : repository.findAll()){
            teach.add(TeacherMapper.entityToDto(t));
        }

        return teach;
    }
}
