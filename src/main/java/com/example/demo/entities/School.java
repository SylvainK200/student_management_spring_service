package com.example.demo.entities;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(notes = "identifier of the school", name = "id", required = true,value = "12345")
    private Long id ;
    @ApiModelProperty(notes = "name of the school", name = "name", required = true,value = "12345")
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
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "shcool"
    )
    private List<User> users;
}
