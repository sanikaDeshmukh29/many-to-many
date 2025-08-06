package com.sprk.many_to_many.service;

import com.sprk.many_to_many.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getAllStudents();
}
