package com.example.demo.entities;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String matricule;
    private int  level;
    private String department;
    @ManyToOne
    private School school;
    @ManyToMany(
            fetch =  FetchType.EAGER
    )
    @JoinTable(
            name= "students_subjects",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="subject_id")
    )
    private List<Subject> subjects;
}
