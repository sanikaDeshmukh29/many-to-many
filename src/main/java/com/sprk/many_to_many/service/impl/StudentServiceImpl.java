package com.sprk.many_to_many.service.impl;

import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.repository.StudentRepository;
import com.sprk.many_to_many.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {

       Student savedStudent = studentRepository.save(student);

       return savedStudent;
    }
}
