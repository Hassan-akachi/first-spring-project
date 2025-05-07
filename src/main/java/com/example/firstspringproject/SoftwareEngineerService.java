package com.example.firstspringproject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    // Injecting the repository to interact with the database
    private final SoftwareEngineerRepository repository;

    public SoftwareEngineerService(SoftwareEngineerRepository repository) {
        this.repository = repository;
    }

    // Get all software engineers
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return repository.findAll();
    }

    // Insert a new software engineer
    public SoftwareEngineer insertSoftwareEngineer(SoftwareEngineer engineer) {
        return repository.save(engineer);
    }

    // Get a software engineer by ID
    public SoftwareEngineer getSoftwareEngineersById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Find software engineers by exact name match
    public List<SoftwareEngineer> getByName(String name) {
        return repository.findByName(name);
    }

    // Find software engineers whose tech stack contains the input (case-insensitive)
    public List<SoftwareEngineer> getByTechStack(String techStack) {
        return repository.findByTechStackContainingIgnoreCase(techStack);
    }

    // Update an existing software engineer by ID
    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer updatedEngineer) {
        return repository.findById(id).map(engineer -> {
            // Update name and tech stack
            engineer.setName(updatedEngineer.getName());
            engineer.setTechStack(updatedEngineer.getTechStack());
            return repository.save(engineer); // Save updated entity
        }).orElse(null); // Return null if not found
    }

    // Delete a software engineer by ID
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
