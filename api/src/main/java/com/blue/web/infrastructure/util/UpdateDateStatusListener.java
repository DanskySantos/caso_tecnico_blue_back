package com.blue.web.infrastructure.util;
import com.blue.web.application.domain.entity.Entity;
import com.blue.web.application.domain.enums.StatusEnum;

import javax.persistence.PrePersist;

public class UpdateDateStatusListener {

    @PrePersist
    public void insertCreationUpdateDate(Entity entity) {
        entity.setDataCriacao(DateTimeUtil.obterDataHoraAtualDeBrasilia());

        if (entity.getStatus() == null) {
            entity.setStatus(StatusEnum.ACTIVE);
        }
    }
}
