package com.example.demo.controler;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class SchoolInfoController {

    @Autowired
    private SchoolRepository repository;

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return repository.save(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School with ID " + id + " not found"));
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable String id, @RequestBody School updated) {
        School existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("School with ID " + id + " not found"));

        updated.setId(existing.getId());
        return repository.save(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable String id) {
        repository.deleteById(id);
    }
}