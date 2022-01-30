package com.example.examapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Teacher {
    @Id
    @Column(
            name = "id",
            nullable = false,
            unique = true,
            updatable = false
    )
    private Long id;

    @Column(
            name = "teacher_name",
            nullable = false
    )
    private String teacherName;

    @Column(
            name = "teacher_subject",
            nullable = false
    )
    private String teacherSubject;

    @Column(name = "teacher_age")
    private Integer teacherAge;


}

