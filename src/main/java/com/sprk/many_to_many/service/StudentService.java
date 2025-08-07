package com.sprk.many_to_many.service;

import com.sprk.many_to_many.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface StudentService {

    public Student addStudent(Student student);

    public Set<Student> getAllStudents();

    public Student findByRollNo(int rollNo);

//    public Student updateStudent(int rollNo, Student student);
}
