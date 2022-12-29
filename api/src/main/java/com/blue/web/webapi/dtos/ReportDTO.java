package com.blue.web.webapi.dtos;

import com.blue.web.application.domain.enums.EnterpriseEnum;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private BigInteger totalVotes;
    private List<VotesPerEnterpriseReportDTO> votesPerEnterprise;
    private List<EnterpriseReportDTO> voteReport;
}
