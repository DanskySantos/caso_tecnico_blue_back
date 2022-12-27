package com.blue.web.webapi.dtos;


import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandardAnswerDTO {

    private boolean sucess = false;

    private String message;

}