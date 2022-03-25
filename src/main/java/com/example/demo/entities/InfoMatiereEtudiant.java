package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
public class InfoMatiereEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date jourNotation;
    private double note;
    private int semestre;
    public enum Session {
        SEGOND_SESSION,FIRST_SESSION
    }
    private Session session;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Student student;
}
