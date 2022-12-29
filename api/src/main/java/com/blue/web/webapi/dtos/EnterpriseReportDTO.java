package com.blue.web.webapi.dtos;

import com.blue.web.application.domain.enums.EnterpriseEnum;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseReportDTO {
    private String name;
    private String email;
    private EnterpriseEnum enterprise;
}
