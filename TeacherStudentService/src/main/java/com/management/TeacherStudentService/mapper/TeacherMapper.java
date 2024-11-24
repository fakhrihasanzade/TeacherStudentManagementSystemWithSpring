package com.management.TeacherStudentService.mapper;

import com.management.TeacherStudentService.dto.TeacherRequestDto;
import com.management.TeacherStudentService.dto.TeacherResponseDto;
import com.management.TeacherStudentService.entity.Teacher;

public class TeacherMapper {

    public static TeacherResponseDto entityToDto(Teacher teacher){

        return TeacherResponseDto.builder()
                .fullName(teacher.getFullName())
                .age(teacher.getAge())
                .email(teacher.getEmail())
                .subject(teacher.getSubject())
                .experience(teacher.getExperience())
                .salary(teacher.getSalary())
                .build();

    }

    public static Teacher dtoToEntity(TeacherRequestDto dto){

        return Teacher.builder()
                .fullName(dto.getFullName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .subject(dto.getSubject())
                .salary(dto.getSalary())
                .experience(dto.getExperience())
                .build();

    }

}
