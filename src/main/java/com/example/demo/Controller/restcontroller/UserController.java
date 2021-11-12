package com.example.demo.Controller.restcontroller;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="/user",tags = "User controller for those who can access the platform")
public class UserController {
    @Autowired
    protected UserService userService;
    @ApiResponses(value = {
            @ApiResponse( code = 200 , message = "SUCCESS", response = User.class),
            @ApiResponse(code = 404, message = "NOT FOUND",response = Exception.class),

    }

    )
    @ApiOperation(value="Creation of a User",response = Iterable.class)
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @ApiOperation(value="Looking for all the Users",response = Iterable.class)
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @ApiOperation(value="Looking for User by id",response = Iterable.class)
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @ApiOperation(value="Delete User by id ",response = Iterable.class)
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Long deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }

    @ApiOperation(value="update information about a User",response = Iterable.class)
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return userService.update(user);
    }
}
