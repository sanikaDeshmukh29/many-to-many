package com.sprk.many_to_many.repository;

import com.sprk.many_to_many.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Club, Integer> {
}
