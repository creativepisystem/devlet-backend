package br.com.creative.devlet.model;

import br.com.creative.devlet.enums.EnumEnterpriseType;

public class GetEnterpriseModel {
    private Long id;
    private String name;
    private Enum<EnumEnterpriseType> type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum<EnumEnterpriseType> getType() {
        return type;
    }

    public void setType(Enum<EnumEnterpriseType> type) {
        this.type = type;
    }
}
