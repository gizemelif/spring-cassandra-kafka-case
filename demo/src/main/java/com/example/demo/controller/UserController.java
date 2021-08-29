package com.example.demo.controller;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired(required = true)
    private UserRepository userRepository;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable("id") int userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not fount " + userId)
        );
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/users")
    public int getFollowerSize() {
        Iterable<User> result = userRepository.findAll();
        List<User> userList = new ArrayList<User>();
        result.forEach(userList::add);
        return userList.size();
    }

    @PostMapping("/user")
    public User save(@RequestBody User newUser){
        int id = new Random().nextInt();
        Date date = new Date();
        User user = new User(id, newUser.getName(), newUser.getSurname(), formatter.format(date));
        userRepository.save(user);
        return user;
    }
}
