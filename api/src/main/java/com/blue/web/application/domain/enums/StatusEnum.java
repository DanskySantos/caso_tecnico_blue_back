package com.blue.web.application.domain.enums;

public enum StatusEnum {
    INACTIVE,
    ACTIVE;

    public boolean isAtivo() {
        return this.equals(ACTIVE);
    }

    public boolean isInativo() {
        return this.equals(INACTIVE);
    }

    public static StatusEnum get(String sigla){
        StatusEnum retorno = null;

        for (StatusEnum value : StatusEnum.values()) {
            if(value.name().equals(sigla)){
                retorno = value;
                break;
            }
        }

        return retorno;
    }
}
