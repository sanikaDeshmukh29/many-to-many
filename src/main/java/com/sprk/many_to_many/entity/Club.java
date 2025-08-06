package com.sprk.many_to_many.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
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
    List<Student> students = new ArrayList<>();

}
