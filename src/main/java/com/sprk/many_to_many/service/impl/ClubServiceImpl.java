package com.sprk.many_to_many.service.impl;

import com.sprk.many_to_many.dto.ClubDto;
import com.sprk.many_to_many.entity.Club;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.repository.ClubRepository;
import com.sprk.many_to_many.repository.StudentRepository;
import com.sprk.many_to_many.service.ClubService;
import com.sprk.many_to_many.util.ClubMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    private final ClubMapper clubMapper;

    private final StudentRepository studentRepository;

    @Override
    public ClubDto saveClub(ClubDto clubDto) {
        Club club = clubMapper.toEntity(clubDto);
        Club saveClub = clubRepository.save(club);

        ClubDto saveClubDto = clubMapper.toDto(saveClub);

        return saveClubDto;
    }

    @Override
    public Set<ClubDto> allClubs() {

       Set<Club> allClubs = new HashSet<>(clubRepository.findAll());
       Set<ClubDto> allClubsDto = new HashSet<>();

       for(Club club : allClubs){
           ClubDto clubDto = clubMapper.toDto(club);
           allClubsDto.add(clubDto);
       }
       return allClubsDto;

    }

    @Override
    public boolean deleteClub(int clubId) {

        Club dbClub = clubRepository.findById(clubId).orElse(null);

        if(dbClub != null){
            clubRepository.delete(dbClub);
            return true;
        }
        return false;
    }

    @Override
    public ClubDto updateClub(int clubId,ClubDto clubDto) {

        Club dbClub = clubRepository.findById(clubId).orElse(null);

        if(dbClub != null){

            dbClub.setClub_id(clubId);
            dbClub.setClubName(clubDto.getClubName());
            dbClub.setClubType(clubDto.getClubType());
            dbClub.setClubDescription(clubDto.getClubDescription());
            dbClub.setCreatedDate(clubDto.getCreatedDate());

        }
        Club savedClub = clubRepository.save(dbClub);



        return clubMapper.toDto(savedClub);
    }
}
