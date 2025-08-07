package com.sprk.many_to_many.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String firstName;

    private String lastName;

    private String phone;

    private LocalDate dob;

    private LocalDate enrollmentDate;


    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "student_club",
            joinColumns = @JoinColumn(name = "student_rollNo"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
            @JsonIgnoreProperties("students")
    Set<Club> clubs = new HashSet<>();
}
