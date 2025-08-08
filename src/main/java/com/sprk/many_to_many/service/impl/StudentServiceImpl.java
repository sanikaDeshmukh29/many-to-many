package com.sprk.many_to_many.service.impl;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Club;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.repository.ClubRepository;
import com.sprk.many_to_many.repository.StudentRepository;
import com.sprk.many_to_many.service.StudentService;
import com.sprk.many_to_many.util.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    private final ClubRepository clubRepository;

    private final StudentMapper studentMapper;

    @Override
    public StudentDto addStudent(StudentDto studentDto) {

       Student saveStudent = studentMapper.toEntity(studentDto);

       Student savedStudent = studentRepository.save(saveStudent);

       return studentMapper.toDto(savedStudent);
    }

    @Override
    public Set<StudentDto> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public StudentDto findByRollNo(int rollNo) {

        Student student = studentRepository.findById(rollNo).orElse(null);

        return studentMapper.toDto(student);

    }

    @Override
    public StudentDto updateStudent(int rollNo, StudentDto studentDto) {

        Student dbStudent = studentRepository.findById(rollNo).orElse(null);

        if(dbStudent != null){

            dbStudent.setRollNo(rollNo);
            Student updatedStudent = studentRepository.save(dbStudent);

            return studentMapper.toDto(updatedStudent);
        }

        return null;
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
