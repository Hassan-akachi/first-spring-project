package com.example.firstspringproject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {

    List<SoftwareEngineer> findByName(String name);


    List<SoftwareEngineer> findByTechStackContainingIgnoreCase(String techStack);
}
