package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "/save-student",consumes = {"application/json", "application/json;charset=UTF-8"})
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){

      StudentDto saveStudent = studentService.addStudent(studentDto);

      return ResponseEntity.ok(saveStudent);

    }


    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStudents(){
        Set<StudentDto> allStudentsDto = studentService.getAllStudents();
        return ResponseEntity.ok(allStudentsDto);
    }

    @GetMapping("/get-by-rollno/{rollNo}")
    public ResponseEntity<?> getByRollNo(@PathVariable int rollNo){

        StudentDto studentDto = studentService.findByRollNo(rollNo);

        return ResponseEntity.ok(studentDto);
    }

    @PutMapping("/edit-student/{rollNo}")
    public ResponseEntity<?> updateStudent(@PathVariable int rollNo, @RequestBody StudentDto studentDto){

        StudentDto updatedStudent = studentService.updateStudent(rollNo,studentDto);

        if(updatedStudent != null){
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("roll number not found");

    }

}
