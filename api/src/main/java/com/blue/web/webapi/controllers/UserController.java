package com.blue.web.webapi.controllers;


import com.blue.web.services.UsersService;
import com.blue.web.webapi.dtos.UserDTO;
import com.blue.web.webapi.dtos.RegisterUserDTO;
import com.blue.web.webapi.dtos.StandardAnswerDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(value = "/register")
    public UserDTO registerUser(@RequestBody RegisterUserDTO registerUserDTO) {

        if (StringUtils.isEmpty(registerUserDTO.getName()))
            throw new RuntimeException("Name should not be null!");
        if (StringUtils.isEmpty(registerUserDTO.getEmail()))
            throw new RuntimeException("Email should not be null!");
        if (StringUtils.isEmpty(registerUserDTO.getPassword()))
            throw new RuntimeException("Password should not be null!");

        return this.usersService.register(registerUserDTO);
    }

    @PostMapping(value = "/login")
    public Object loginUser(@RequestBody UserDTO userDTO) {

        if (StringUtils.isEmpty(userDTO.getEmail()))
            throw new RuntimeException("Email should not be null!");
        if (StringUtils.isEmpty(userDTO.getPassword()))
            throw new RuntimeException("Password should not be null!");

        Object login = this.usersService.login(userDTO);

        return login;
    }

    @GetMapping(value = "/{email}")
    public UserDTO retrieveUser(@PathVariable String email) {

        if (StringUtils.isEmpty(email))
            throw new RuntimeException("Email should not be null!");

        return this.usersService.retrieve(email);
    }
}
