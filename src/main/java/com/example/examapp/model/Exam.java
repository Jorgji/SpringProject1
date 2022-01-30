package com.example.examapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.PutMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Exam {
    @Id
    @Column(
            name = "id",
            nullable = false,
            unique = true,
            updatable = false
    )
    private Long id;

    @Column(
            name = "exam_name",
            nullable = false
    )
    private String examName;

    @Column(
            name = "hosting_teacher",
            nullable = false
    )
    private String hostingTeacher;

    @Column(name = "exam_grade")
    private Integer examGrade;
    @ManyToMany
    @JoinTable(
            name = "students_enrolled",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")

    )
    private List<Student> enrolledStudents = new ArrayList<Student>();
    public void enrollStudent(Student student){
        enrolledStudents.add(student);
    }


            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


}
