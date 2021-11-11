package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Struct;
import java.util.*;

@Data
@Entity
@Table(name="schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable=false)
    private String name ;
    private String quater;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "school"
    )
    private List<Student> students;
    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }

}
