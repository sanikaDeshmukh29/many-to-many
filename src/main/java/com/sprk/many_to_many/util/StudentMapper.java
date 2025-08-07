package com.sprk.many_to_many.util;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "clubIds", source = "clubs", qualifiedByName = "mapClubsToIds")
    StudentDto toDto(Student student);

    @Mapping(target = "clubs", source = "clubIds", qualifiedByName = "mapIdsToClubs")
    Student toEntity(StudentDto studentDto);

    @Named("mapClubsToIds")
    default Set<Integer> mapClubsToIds(Set<Club> clubs) {
        if (clubs == null) return null;
        return clubs.stream().map(Club::getClub_id).collect(Collectors.toSet());
    }

    @Named("mapIdsToClubs")
    default Set<Club> mapIdsToClubs(Set<Integer> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            Club club = new Club();
            club.setClub_id(id);
            return club;
        }).collect(Collectors.toSet());
    }
}
