package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.dto.ClubDto;
import com.sprk.many_to_many.entity.Club;
import com.sprk.many_to_many.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class ClubController {

    private final ClubService clubService;

    @PostMapping("/add-club")
    public ResponseEntity<?> addClub(@RequestBody ClubDto clubDto){

        return ResponseEntity.ok(clubService.saveClub(clubDto));

    }

    @GetMapping("/get-all-clubs")
    public ResponseEntity<?> getAllClubs(){

        return ResponseEntity.ok(clubService.allClubs());
    }

    @DeleteMapping("delete-club/{clubId}")
    public ResponseEntity<?> deleteClub(@PathVariable int clubId){

        boolean isDeleted = clubService.deleteClub(clubId);
        if(isDeleted) {
            return ResponseEntity.ok("club deleted successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("club not found");
    }

    @PutMapping("update-club/{clubId}")
    public ResponseEntity<?> updateClub(@PathVariable int clubId, @RequestBody ClubDto clubDto){

       ClubDto updatedDto = clubService.updateClub(clubId,clubDto);
       if(updatedDto != null){
           return ResponseEntity.ok(updatedDto);
    }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("club not found");
    }

    @PutMapping("add-student-to-club/{clubId}/{studentRollNo}")
    public ResponseEntity<?> addStudentToClub(@PathVariable int clubId, @PathVariable int studentRollNo){

        ClubDto addStudentToClub = clubService.addStudentToClub(clubId,studentRollNo);

        return ResponseEntity.ok(addStudentToClub);

    }


}
