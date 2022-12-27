package com.blue.web.infrastructure.repositories;

import com.blue.web.application.domain.entity.Users;
import com.blue.web.application.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Transactional
    @Modifying
    @Query("update Users u set u.vote = ?1 where u.email = ?2")
    void updateVote(Vote vote, String email);

    Users findByEmailIgnoreCase(String email);
}
