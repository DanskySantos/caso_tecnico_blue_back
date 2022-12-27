package com.blue.web.services;

import com.blue.web.application.domain.entity.Users;
import com.blue.web.application.domain.entity.Vote;
import com.blue.web.application.domain.enums.EnterpriseEnum;
import com.blue.web.infrastructure.repositories.UsersRepository;
import com.blue.web.infrastructure.repositories.VoteRepository;
import com.blue.web.webapi.dtos.RegisterVoteDTO;
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

public class VoteServiceTest {

    @InjectMocks
    private VoteService voteService;

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private UsersRepository usersRepository;

    @BeforeEach
    void setup() {
        openMocks(this);
    }

    @DisplayName("When register vote, then success")
    @Test
    void whenRegisterVote_thenSuccess() {

        //GIVEN
        Users users = new Users();
        users.setEmail("ricardskdjdk@gmail.com");
        users.setName("Ricardo");
        users.setPassword("123456");
        RegisterVoteDTO registerVoteDTO = new RegisterVoteDTO();
        registerVoteDTO.setEnterprise(EnterpriseEnum.EVIAN.name());
        registerVoteDTO.setUser(users);

        //WHEN
        when(usersRepository.findByEmailIgnoreCase(users.getEmail())).thenReturn(users);
        voteService.registerVote(registerVoteDTO);

        //THEN
        verify(voteRepository, times(1)).save(any());
    }

    @Test
    void whenRegisterVoteAndAlreadyExists_thenThrowException() {
        //GIVEN
        Users users = new Users();
        users.setEmail("ricardskdjdk@gmail.com");
        users.setName("Ricardo");
        users.setPassword("123456");
        users.setVote(new Vote());
        users.getVote().setEnterprise(EnterpriseEnum.EVIAN);
        RegisterVoteDTO registerVoteDTO = new RegisterVoteDTO();
        registerVoteDTO.setEnterprise(EnterpriseEnum.EVIAN.name());
        registerVoteDTO.setUser(users);

        //WHEN
        when(usersRepository.findByEmailIgnoreCase(users.getEmail())).thenReturn(users);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> voteService.registerVote(registerVoteDTO));


        //THEN
        verify(voteRepository, times(0)).save(any());
        assertEquals("You already voted!", exception.getMessage());
    }
}
