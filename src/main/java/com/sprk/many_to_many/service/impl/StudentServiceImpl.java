package com.sprk.many_to_many.service.impl;

import com.sprk.many_to_many.entity.Club;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.repository.ClubRepository;
import com.sprk.many_to_many.repository.StudentRepository;
import com.sprk.many_to_many.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    private final ClubRepository clubRepository;

    @Override
    public Student addStudent(Student student) {

       Student savedStudent = studentRepository.save(student);

       return savedStudent;
    }

    @Override
    public Set<Student> getAllStudents() {

        return new HashSet<>(studentRepository.findAll());
    }

    @Override
    public Student findByRollNo(int rollNo) {

        return studentRepository.findById(rollNo).orElse(null);

    }

//    @Override
//    public Student updateStudent(int rollNo, Student student) {
//
//        Student existingStudent = studentRepository.findById(rollNo).orElse(null);
//        List<Club> existingClubs = new ArrayList<>();
//
//        if(existingStudent != null){
//
//            existingStudent.setFirstName(student.getFirstName());
//            existingStudent.setLastName(student.getLastName());
//            existingStudent.setPhone(student.getPhone());
//            existingStudent.setDob(student.getDob());
//            existingStudent.setEnrollmentDate(student.getEnrollmentDate());
//
//
//
//            for(Club club : student.getClubs()){
//                if(club.getClub_id() != 0){
//                    Club existingClub = clubRepository.findById(club.getClub_id()).orElse(null);
//
//                    if(existingClub != null){
//                        existingClubs.add(existingClub);
//                    }
//                }
//            }
//
//            existingStudent.setClubs(existingClubs);
//
//            return studentRepository.save(existingStudent);
//        }
//        return null;
//    }


}
