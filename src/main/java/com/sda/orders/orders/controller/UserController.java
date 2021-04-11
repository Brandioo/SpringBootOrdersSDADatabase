package com.sda.orders.orders.controller;

import com.sda.orders.orders.model.Users;
import com.sda.orders.orders.repository.UserRepository;
import com.sda.orders.orders.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    UserService userService = new UserService();

    @GetMapping("user")
    public String hello() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String hi() {
        return "Hello ADMIN";
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<Users> addUser(@RequestBody Users users) {
        return new ResponseEntity<Users>(userService.addUser(users),
                HttpStatus.CREATED);

    }

    @GetMapping("users")
    public ResponseEntity<List<Users>> getUsers() {

        return new ResponseEntity<List<Users>>(userService.userList(),
                HttpStatus.CREATED);

    }

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/allUsers")
    public List<Users> searchAll() {
        List<Users> usersList = new ArrayList<>();
        Iterable<Users> userses = userRepository.findAll();
        userses.forEach(usersList::add);
        return usersList;
    }

    @Autowired
    UserRepository usersRepository;

    @GetMapping(value = "/userName/{text}")
    public List<Users> searchUserName(@PathVariable final String text) {
        return usersRepository.findByusername(text);
    }

    @PutMapping("users")
    public ResponseEntity<Users> updateStudent(@Valid @RequestBody Users users) {
        return new ResponseEntity<Users>(userService.updateUser(users),
                HttpStatus.OK);
    }

}