package com.example.examapp.controller;

import com.example.examapp.model.Exam;
import com.example.examapp.model.Student;
import com.example.examapp.model.Teacher;
import com.example.examapp.repository.ExamRepository;
import com.example.examapp.repository.StudentRepository;
import com.example.examapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class TeacherController {

    private final TeacherRepository teacherRepository;


    public TeacherController( TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;


    }
    @GetMapping("/all/teachers")
    public List<Teacher> allTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("add/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/delete/teacher/{id}")
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }


}



