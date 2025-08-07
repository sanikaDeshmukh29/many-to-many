package com.sprk.many_to_many.util;

import com.sprk.many_to_many.dto.ClubDto;
import com.sprk.many_to_many.entity.Club;
import com.sprk.many_to_many.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    @Mapping(target = "studentRollNo", source = "students", qualifiedByName = "mapStudentsToRollNos")
    ClubDto toDto(Club club);

    @Mapping(target = "students", source = "studentRollNo", qualifiedByName = "mapRollNosToStudents")
    Club toEntity(ClubDto clubDto);

    @Named("mapStudentsToRollNos")
    default Set<Integer> mapStudentsToRollNos(Set<Student> students) {
        if (students == null) return null;
        return students.stream().map(Student::getRollNo).collect(Collectors.toSet());
    }

    @Named("mapRollNosToStudents")
    default Set<Student> mapRollNosToStudents(Set<Integer> rollNos) {
        if (rollNos == null) return null;
        return rollNos.stream().map(rollNo -> {
            Student student = new Student();
            student.setRollNo(rollNo);
            return student;
        }).collect(Collectors.toSet());
    }
}
