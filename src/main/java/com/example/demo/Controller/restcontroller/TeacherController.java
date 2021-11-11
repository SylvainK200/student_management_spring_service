package com.example.demo.Controller.restcontroller;

import com.example.demo.entities.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TeacherController {

    @Autowired
    protected TeacherService teacherService;

    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public Teacher create(@RequestBody Teacher teacher){
        return teacherService.create(teacher);
    }
    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public List<Teacher> findAllTeachers(){
        return teacherService.findAll();
    }
    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET)
    public Teacher findById(@PathVariable Long id){
        return teacherService.findById(id);
    }
    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.DELETE)
    public Long deleteById(@PathVariable Long id){
        return teacherService.deleteById(id);
    }
    @RequestMapping(value = "/teacher",method = RequestMethod.PUT)
    public Teacher update(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }
}
