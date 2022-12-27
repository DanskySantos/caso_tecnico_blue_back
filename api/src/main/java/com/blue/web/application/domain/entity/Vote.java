package com.blue.web.application.domain.entity;

import com.blue.web.application.domain.enums.EnterpriseEnum;
import lombok.*;

import javax.persistence.*;

@javax.persistence.Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vote extends Entity {

    @OneToOne(mappedBy = "vote", cascade = CascadeType.ALL)
    private Users user;

    @Column
    private EnterpriseEnum enterprise;
}
