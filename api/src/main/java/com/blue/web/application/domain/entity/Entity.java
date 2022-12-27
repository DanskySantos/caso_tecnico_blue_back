package com.blue.web.application.domain.entity;

import com.blue.web.application.domain.enums.StatusEnum;
import com.blue.web.infrastructure.util.UpdateDateStatusListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(UpdateDateStatusListener.class)
public class Entity implements Serializable {

    private static final long serialVersionUID = 3270601256011818010L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Access(AccessType.PROPERTY)
    protected Long id;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "TEXT default 'ACTIVE'")
    private StatusEnum status;

    public Entity() {
    }

    public Entity(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() == null ? super.hashCode() : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (obj.getClass().equals(getClass())) && obj.hashCode() == hashCode();
    }
}
