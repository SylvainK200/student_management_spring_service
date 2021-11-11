package com.example.demo.Controller.restcontroller;

import com.example.demo.entities.School;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SchoolController {

    @Autowired
    protected SchoolService schoolService;

    @RequestMapping(value = "/school",method = RequestMethod.POST)
    public School create(@RequestBody School school){
        return schoolService.create(school);
    }
    @RequestMapping(value = "/school",method = RequestMethod.GET)
    public List<School> findAllSchools(){
        return schoolService.findAll();
    }
    @RequestMapping(value = "/school/{id}",method = RequestMethod.GET)
    public School findById(@PathVariable Long id){
        return schoolService.findById(id);
    }
    @RequestMapping(value = "/school/{id}",method = RequestMethod.DELETE)
    public Long deleteById(@PathVariable Long id){
        return schoolService.deleteById(id);
    }
    @RequestMapping(value = "/school",method = RequestMethod.PUT)
    public School update(@RequestBody School school){
        return schoolService.update(school);
    }
}
