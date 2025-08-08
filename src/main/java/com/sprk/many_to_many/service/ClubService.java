package com.sprk.many_to_many.service;

import com.sprk.many_to_many.dto.ClubDto;
import com.sprk.many_to_many.entity.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface ClubService {

    public ClubDto saveClub(ClubDto clubDto);

    public Set<ClubDto> allClubs();

    public boolean deleteClub(int clubId);

    public ClubDto updateClub(int clubId,ClubDto clubDto);

    public ClubDto addStudentToClub(int clubId, int studentRollNo);
}
