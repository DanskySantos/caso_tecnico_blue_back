package com.blue.web.application.domain.entity;

import lombok.*;

import javax.persistence.*;

@javax.persistence.Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends Entity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    private Vote vote;
}
