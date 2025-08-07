package com.sprk.many_to_many.controller;

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
    public ResponseEntity<?> addStudent(@RequestBody Student student){

      Student saveStudent = studentService.addStudent(student);

      return ResponseEntity.ok(saveStudent);

    }


    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStudents(){
        Set<Student> allStudents = studentService.getAllStudents();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/get-by-rollno/{rollNo}")
    public ResponseEntity<?> getByRollNo(@PathVariable int rollNo){

        Student student = studentService.findByRollNo(rollNo);

        return ResponseEntity.ok(student);
    }

//    @PutMapping("/edit-student/{rollNo}")
//    public ResponseEntity<?> updateStudent(@PathVariable int rollNo, @RequestBody Student student){
//
//        Student updatedStudent = studentService.updateStudent(rollNo,student);
//
//        if(updatedStudent != null){
//            return ResponseEntity.ok(updatedStudent);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("roll number not found");
//
//    }

}
