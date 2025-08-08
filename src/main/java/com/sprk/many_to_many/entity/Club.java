package com.sprk.many_to_many.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int club_id;

    private String clubName;

    private String clubType;

    private String clubDescription;

    private LocalDateTime createdDate;

    @ManyToMany(mappedBy = "clubs")
    @JsonIgnoreProperties("clubs")
    Set<Student> students = new HashSet<>();

}
