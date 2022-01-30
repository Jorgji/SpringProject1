package com.example.examapp.controller;


import com.example.examapp.model.Student;
import com.example.examapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class StudentController {
    @Autowired

    private final StudentRepository studentRepository;


    public StudentController( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;


    }


    @GetMapping("/allstudents")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){return studentRepository.save(student);}

    @DeleteMapping("/delete/student/{id}")
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
