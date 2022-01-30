package com.example.examapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity(name = "Student")
public class Student {
    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            unique = true

    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;


    @Column(name = "age")
    private Integer age;
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Exam> exams = new ArrayList<Exam>();


}
