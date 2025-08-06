package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "/save-student",consumes = {"application/json", "application/json;charset=UTF-8"})
    public ResponseEntity<?> addStudent(@RequestBody Student student){

      Student saveStudent = studentService.addStudent(student);

      return ResponseEntity.ok(saveStudent);

    }
}
