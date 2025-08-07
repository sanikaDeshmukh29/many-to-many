package com.sprk.many_to_many.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private int rollNo;

    private String firstName;

    private String lastName;

    private String phone;

    private LocalDate dob;

    private LocalDate enrollmentDate;

    private Set<Integer> clubIds;


}
