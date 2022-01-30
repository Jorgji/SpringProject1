package com.example.examapp.repository;
import com.example.examapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
