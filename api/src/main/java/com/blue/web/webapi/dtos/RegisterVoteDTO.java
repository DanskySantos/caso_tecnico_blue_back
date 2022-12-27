package com.blue.web.webapi.dtos;

import com.blue.web.application.domain.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVoteDTO {

    private Users user;

    private String enterprise;
}
