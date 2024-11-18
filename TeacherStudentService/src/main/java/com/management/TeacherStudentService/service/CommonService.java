package com.management.TeacherStudentService.service;

import java.util.List;

public interface CommonService<T> {

    List<T> getAll();

    T getById(Long id);

    void delete(Long id);

    void save(T obj);

    void update(Long id, T obj);

}
