package com.blue.web.webapi.dtos;

import com.blue.web.application.domain.entity.Vote;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {
    private String name;
    private String email;
    private String password;
    private Long voteId;
}
