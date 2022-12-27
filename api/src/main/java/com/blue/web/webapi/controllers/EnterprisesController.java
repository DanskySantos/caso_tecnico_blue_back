package com.blue.web.webapi.controllers;


import com.blue.web.application.domain.enums.EnterpriseEnum;
import com.blue.web.services.EnterprisesService;
import com.blue.web.webapi.dtos.EnterpriseDTO;
import com.blue.web.webapi.dtos.StandardAnswerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprises")
public class EnterprisesController {

    private final EnterprisesService enterprisesService;

    public EnterprisesController(EnterprisesService enterprisesService) {
        this.enterprisesService = enterprisesService;
    }

    @GetMapping(value = "/list")
    public List<EnterpriseDTO> listEnterprises() {

        return enterprisesService.listEnterprises();
    }
}
