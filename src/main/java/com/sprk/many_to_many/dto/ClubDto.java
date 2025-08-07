package com.sprk.many_to_many.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {

    private String clubName;

    private String clubType;

    private String clubDescription;

    private LocalDateTime createdDate;

    private Set<Integer> studentRollNo;
}
