package com.example.postviflandmanagement.controller;

import com.example.postviflandmanagement.user.User;
import com.example.postviflandmanagement.model.UserRequestDTO;
import com.example.postviflandmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> postUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return userService.save(userRequestDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id){
        return userService.deleteUser(id);
    }
}
