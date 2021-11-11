package com.example.demo.Controller.restcontroller;

import com.example.demo.entities.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SubjectController {

    @Autowired
    protected SubjectService subjectService;

    @RequestMapping(value = "/subject",method = RequestMethod.POST)
    public Subject create(@RequestBody Subject subject){
        return subjectService.create(subject);
    }
    @RequestMapping(value = "/subject",method = RequestMethod.GET)
    public List<Subject> findAllSubjects(){
        return subjectService.findAll();
    }
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.GET)
    public Subject findById(@PathVariable Long id){
        return subjectService.findById(id);
    }
    @RequestMapping(value = "/subject/{id}",method = RequestMethod.DELETE)
    public Long deleteById(@PathVariable Long id){
        return subjectService.deleteById(id);
    }
    @RequestMapping(value = "/subject",method = RequestMethod.PUT)
    public Subject update(@RequestBody Subject subject){
        return subjectService.update(subject);
    }
}
