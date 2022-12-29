package com.blue.web.webapi.dtos;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NumberVotesDTO {
    private BigInteger votes;
}
