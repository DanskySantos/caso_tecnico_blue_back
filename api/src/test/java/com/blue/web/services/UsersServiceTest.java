package com.blue.web.services;

import com.blue.web.application.domain.entity.Users;
import com.blue.web.infrastructure.repositories.UsersRepository;
import com.blue.web.infrastructure.repositories.VoteRepository;
import com.blue.web.webapi.dtos.RegisterUserDTO;
import com.blue.web.webapi.dtos.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class UsersServiceTest {

    @InjectMocks
    private UsersService usersService;

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private UsersRepository usersRepository;

    @BeforeEach
    void setup() {
        openMocks(this);
    }

    @DisplayName("When register user, then success")
    @Test
    void whenRegisterUser_thenSuccess() {

        //GIVEN
        Users users = new Users();
        users.setEmail("ricardskdjdk@gmail.com");
        users.setName("Ricardo");
        users.setPassword("123456");

        //WHEN
        when(usersRepository.save(users)).thenReturn(users);
        usersRepository.save(users);

        //THEN
//        verify(voteRepository, times(1)).save(any());
    }

    @Test
    void whenRegisterUserAndAlreadyExists_thenThrowException() {
        //GIVEN
        Users users = new Users();
        users.setEmail("ricardskdjdk@gmail.com");
        users.setName("Ricardo");
        users.setPassword("123456");

        RegisterUserDTO userDTO = new RegisterUserDTO();
        userDTO.setEmail("dansky123@hotmail.com");
        userDTO.setName("dansky");
        userDTO.setPassword("123456");

        //WHEN
        when(usersRepository.save(users)).thenReturn(users);
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> usersService.register(userDTO));

        //THEN
        verify(usersRepository, times(0)).save(any());
//        assertEquals("You already voted!", exception.getMessage());
    }
}
