package com.example.demo.Controller.restcontroller;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {

    @Autowired
    protected StudentService studentService;

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> findAllStudents(){
        return studentService.findAll();
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public Long deleteById(@PathVariable Long id){
        return studentService.deleteById(id);
    }
    @RequestMapping(value = "/student",method = RequestMethod.PUT)
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

}
