package com.blue.web.services;

import com.blue.web.application.domain.enums.EnterpriseEnum;
import com.blue.web.webapi.dtos.EnterpriseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class EnterprisesServiceTest {

    @Mock
    private EnterprisesService enterprisesService;

    @BeforeEach
    void setup() {
        openMocks(this);
    }

    @DisplayName("When list enterprises, then success")
    @Test
    void whenListEnterprises_thenSuccess() {

        //GIVEN
        List<EnterpriseDTO> list = new ArrayList<>();

        for (EnterpriseEnum value : EnterpriseEnum.values()) {
            EnterpriseDTO enterpriseDTO = new EnterpriseDTO();

            enterpriseDTO.setName(value.getNome());
            enterpriseDTO.setImage(value.getImagem());
            enterpriseDTO.setEnumName(value.name());

            list.add(enterpriseDTO);
        }

        //WHEN
        when(enterprisesService.listEnterprises()).thenReturn(list);

        //THEN
        verify(enterprisesService, times(0)).listEnterprises();
    }
}