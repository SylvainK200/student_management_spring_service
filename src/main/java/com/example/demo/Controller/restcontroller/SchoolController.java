package com.example.demo.Controller.restcontroller;

import com.example.demo.entities.School;
import com.example.demo.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value="/school",tags = "School controller of the API, with associated routes")
@RestController
public class SchoolController {

    @Autowired
    protected SchoolService schoolService;
    @ApiResponses(value = {
            @ApiResponse( code = 200 , message = "SUCCESS", response = School.class),
            @ApiResponse(code = 404, message = "NOT FOUND",response = Exception.class),
            
    }

    )
    @ApiOperation(value="Creation of a School",response = Iterable.class)
    @RequestMapping(value = "/school",method = RequestMethod.POST)
    public School create(@RequestBody School school){
        return schoolService.create(school);
    }

    @ApiOperation(value="Looking for all the schools",response = Iterable.class)
    @RequestMapping(value = "/school",method = RequestMethod.GET)
    public List<School> findAllSchools(){
        return schoolService.findAll();
    }

    @ApiOperation(value="Looking for school by id",response = Iterable.class)
    @RequestMapping(value = "/school/{id}",method = RequestMethod.GET)
    public School findById(@PathVariable Long id){
        return schoolService.findById(id);
    }

    @ApiOperation(value="Delete school by id ",response = Iterable.class)
    @RequestMapping(value = "/school/{id}",method = RequestMethod.DELETE)
    public Long deleteById(@PathVariable Long id){
        return schoolService.deleteById(id);
    }

    @ApiOperation(value="update information about a school",response = Iterable.class)
    @RequestMapping(value = "/school",method = RequestMethod.PUT)
    public School update(@RequestBody School school){
        return schoolService.update(school);
    }
}
