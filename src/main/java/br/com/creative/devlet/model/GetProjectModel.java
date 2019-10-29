package br.com.creative.devlet.model;

import java.math.BigDecimal;

public class GetProjectModel {
    private Long id;
    private String name;
    private String description;
    private BigDecimal budget;
    private Integer estimatedHours;
    private GetEnterpriseModel client;
    private GetEnterpriseModel enterprise;
    private GetTeamModel team;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public GetEnterpriseModel getClient() {
        return client;
    }

    public void setClient(GetEnterpriseModel client) {
        this.client = client;
    }

    public GetEnterpriseModel getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(GetEnterpriseModel enterprise) {
        this.enterprise = enterprise;
    }

    public GetTeamModel getTeam() {
        return team;
    }

    public void setTeam(GetTeamModel team) {
        this.team = team;
    }
}
