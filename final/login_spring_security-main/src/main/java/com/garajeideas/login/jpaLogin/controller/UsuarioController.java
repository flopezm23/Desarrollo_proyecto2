package com.garajeideas.login.jpaLogin.controller;

import com.garajeideas.login.jpaLogin.dto.UserDTO;
import com.garajeideas.login.jpaLogin.entity.User;
import com.garajeideas.login.jpaLogin.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UsuarioController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        if (userDetailsService.usernameExists(userDTO.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        userDetailsService.saveUser(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
