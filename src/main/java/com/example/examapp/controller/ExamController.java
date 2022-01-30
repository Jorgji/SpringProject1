package com.example.examapp.controller;

import com.example.examapp.model.Student;
import com.example.examapp.model.Exam;
import com.example.examapp.model.Teacher;
import com.example.examapp.repository.StudentRepository;
import com.example.examapp.repository.ExamRepository;
import com.example.examapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ExamController {
    @Autowired
    ExamRepository examRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }


    @GetMapping("/all/exams")
    public List<Exam> allExams() {
        return examRepository.findAll();
    }

    @PostMapping("/add/exam")
    public Exam addExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @DeleteMapping("/delete/exam/{id}")
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }
    @PutMapping("/exam/{exam_id}/student/{student_id}")
    Exam addStudentToExam(
            @PathVariable Long exam_id,
            @PathVariable Long student_id
    ){

        Exam exam = examRepository.findById(exam_id).get();
        Student student= studentRepository.findById(student_id).get();
        exam.enrollStudent(student);
        return examRepository.save(exam);
    }

}

