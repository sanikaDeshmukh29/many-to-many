package com.sprk.many_to_many.service;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface StudentService {

    public StudentDto addStudent(StudentDto studentDto);

    public Set<StudentDto> getAllStudents();

    public StudentDto findByRollNo(int rollNo);

    public StudentDto updateStudent(int rollNo, StudentDto studentDto);
}
