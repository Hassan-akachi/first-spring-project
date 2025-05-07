package com.example.firstspringproject;

import com.example.firstspringproject.SoftwareEngineer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vi/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService service;

    public SoftwareEngineerController(SoftwareEngineerService service) {
        this.service = service;
    }

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return service.getAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getById(@PathVariable Integer id) {
        return service.getSoftwareEngineersById(id);
    }

    @PostMapping
    public SoftwareEngineer create(@RequestBody SoftwareEngineer softwareEngineer) {
        return service.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("/name/{name}")
    public List<SoftwareEngineer> getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @GetMapping("/tech/{tech}")
    public List<SoftwareEngineer> getByTech(@PathVariable String tech) {
        return service.getByTechStack(tech);
    }

    // PUT endpoint to update an engineer by ID
    @PutMapping("/{id}")
    public SoftwareEngineer updateById(@PathVariable Integer id, @RequestBody SoftwareEngineer updatedEngineer) {
        return service.updateSoftwareEngineer(id, updatedEngineer);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
