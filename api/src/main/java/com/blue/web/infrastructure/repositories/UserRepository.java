package com.blue.web.infrastructure.repositories;

import com.blue.web.application.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailIgnoreCase(String email);
}
