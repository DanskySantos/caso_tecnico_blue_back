package com.blue.web.services;

import com.blue.web.application.domain.entity.Users;
import com.blue.web.application.domain.entity.Vote;
import com.blue.web.application.domain.enums.EnterpriseEnum;
import com.blue.web.infrastructure.repositories.UsersRepository;
import com.blue.web.infrastructure.repositories.VoteRepository;
import com.blue.web.webapi.dtos.RegisterVoteDTO;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    private final UsersRepository usersRepository;


    public VoteService(VoteRepository voteRepository, UsersRepository usersRepository) {
        this.voteRepository = voteRepository;
        this.usersRepository = usersRepository;
    }

    public void registerVote(RegisterVoteDTO registerVoteDTO) {
        Vote vote = new Vote();

        Users user = usersRepository.findByEmailIgnoreCase(registerVoteDTO.getUser().getEmail());

        if (user.getVote() != null) {
            throw new RuntimeException("You already voted!");
        } else {
            vote.setUser(user);
            vote.setEnterprise(EnterpriseEnum.valueOf(registerVoteDTO.getEnterprise()));

            user.setVote(vote);
            voteRepository.save(vote);
            usersRepository.updateVote(vote, vote.getUser().getEmail());
        }
    }
}
