package com.griddynamics.springbootlearning.controller;

import com.griddynamics.springbootlearning.model.User;
import com.griddynamics.springbootlearning.repository.UserRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/name/{userName}")
    public List findByName(@PathVariable String name){
        return userRepository.findByName(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
