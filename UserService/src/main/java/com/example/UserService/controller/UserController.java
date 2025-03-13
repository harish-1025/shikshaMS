package com.example.UserService.controller;

import com.example.UserService.dto.UserDto;
import com.example.UserService.entity.User;
import com.example.UserService.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/getAllUser")
    public List<UserDto> getAllUsers(){
        return userServiceImpl.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try{
            UserDto userDto=userServiceImpl.getUserById(id);
            return ResponseEntity.ok(userDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody User user) {
        return userServiceImpl.registerUser(user);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> update(@RequestBody User user){
        try {
            UserDto updatedUser=userServiceImpl.update(user);
            return ResponseEntity.ok(updatedUser);
        }catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        try {
            userServiceImpl.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
