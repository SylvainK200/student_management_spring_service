package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    private String department;
    @Column(nullable = false)
    private String name;
    private int numberOfCredit;
    @ManyToMany(
            mappedBy = "subjects",
            fetch= FetchType.LAZY
    )
    private List<Student> students;
    @ManyToOne(fetch = FetchType.EAGER)

    private Teacher teacher;
}
