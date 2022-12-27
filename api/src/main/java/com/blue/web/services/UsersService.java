package com.blue.web.services;

import com.blue.web.application.domain.entity.Users;
import com.blue.web.infrastructure.repositories.UsersRepository;
import com.blue.web.webapi.dtos.UserDTO;
import com.blue.web.webapi.dtos.RegisterUserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDTO register(RegisterUserDTO registerUserDTO) {
        Users user = new Users();

        UserDTO userDto = new UserDTO();

        if (usersRepository.findByEmailIgnoreCase(registerUserDTO.getEmail()) == null) {
            user.setEmail(registerUserDTO.getEmail());
            user.setName(registerUserDTO.getName());
            user.setPassword(registerUserDTO.getPassword());

            usersRepository.save(user);

            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
        } else {
            if (Objects.equals(registerUserDTO.getEmail(), usersRepository.findByEmailIgnoreCase(registerUserDTO.getEmail()).getEmail())) {
                throw new RuntimeException("You are already registered!");
            }
        }
        return userDto;
    }

    public Object login(UserDTO userDTO) {
        Users users = new Users();

        if (userDTO.getEmail() != null) {
            users = usersRepository.findByEmailIgnoreCase(userDTO.getEmail());
        } else {
            throw new RuntimeException("Incorrect login or password! Try to Register!");
        }

        if (!StringUtils.equals(users.getPassword(), userDTO.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        if (!StringUtils.equals(users.getEmail(), userDTO.getEmail())) {
            throw new RuntimeException("Invalid email!");
        }

        UserDTO userToReturn = new UserDTO();

        userToReturn.setEmail(users.getEmail());
        userToReturn.setName(users.getName());
        userToReturn.setPassword(users.getPassword());
        if (users.getVote() != null) {
            userToReturn.setVoteId(users.getVote().getId());
        }

        return userToReturn;
    }

    public UserDTO retrieve(String email) {
        UserDTO userDTO = new UserDTO();

        Users user = usersRepository.findByEmailIgnoreCase(email);

        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        if (user.getVote() != null) {
            userDTO.setVoteId(user.getVote().getId());
        }

        return userDTO;
    }

}
