package com.example.demo.Controller.restcontroller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
   // @PreAuthorize("hasRole('ADMIN')")
    public User create(@RequestBody User user){
        System.out.println("consommation");
        return userService.create(user);
    }

    @ApiOperation(value="Looking for all the Users",response = Iterable.class)
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    //@PreAuthorize("hasRole('ADMIN')")
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


    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String authorizationHeader  = request.getHeader(AUTHORIZATION);
        if (authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                System.out.println(username);
                User user = userService.getUser(username);
                String access_token = JWT.create().
                        withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(role-> role.getRole()).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String,String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token",refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);

            }catch (Exception e ){
                response.setHeader("error",e.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());

                Map<String,String> error = new HashMap<>();
                error.put("error_message", e.getMessage());

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }

        }else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
