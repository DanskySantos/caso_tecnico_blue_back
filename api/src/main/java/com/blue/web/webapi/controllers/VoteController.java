package com.blue.web.webapi.controllers;


import com.blue.web.application.domain.enums.EnterpriseEnum;
import com.blue.web.services.VoteService;
import com.blue.web.webapi.dtos.RegisterVoteDTO;
import com.blue.web.webapi.dtos.StandardAnswerDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(value = "/vote")
    public StandardAnswerDTO registerVote(@RequestBody RegisterVoteDTO registerVoteDTO) {

        if (registerVoteDTO.getUser() == null)
            throw new RuntimeException("User should not be null!");
        if (registerVoteDTO.getEnterprise() == null)
            throw new RuntimeException("Enterprise should not be null!");

        voteService.registerVote(registerVoteDTO);

        return new StandardAnswerDTO(true, "Vote Registered!");
    }
}
