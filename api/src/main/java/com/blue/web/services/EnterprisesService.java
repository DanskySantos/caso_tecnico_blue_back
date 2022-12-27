package com.blue.web.services;

import com.blue.web.application.domain.enums.EnterpriseEnum;
import com.blue.web.webapi.dtos.EnterpriseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterprisesService {

    public List<EnterpriseDTO> listEnterprises() {

        List<EnterpriseDTO> list = new ArrayList<>();

        for (EnterpriseEnum value : EnterpriseEnum.values()) {
            EnterpriseDTO enterpriseDTO = new EnterpriseDTO();

            enterpriseDTO.setName(value.getNome());
            enterpriseDTO.setImage(value.getImagem());
            enterpriseDTO.setEnumName(value.name());

            list.add(enterpriseDTO);
        }

        return list;
    }
}
