package com.blue.web.webapi.dtos;

import com.blue.web.application.domain.enums.EnterpriseEnum;
import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotesPerEnterpriseReportDTO {
    private BigInteger id;
    private String name;
    private BigInteger totalVotes;
}
