package com.blue.web.webapi.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDTO {
    private String name;
    private String image;
    private String enumName;
}
