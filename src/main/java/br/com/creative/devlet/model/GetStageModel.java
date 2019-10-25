package br.com.creative.devlet.model;


import java.util.Date;

public class GetStageModel {
    private Long id;
    private String name;
    private String description;
    private Date date;
    private GetProjectModel project;
    private GetEnterpriseModel enterprise;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GetProjectModel getProject() {
        return project;
    }

    public void setProject(GetProjectModel project) {
        this.project = project;
    }

    public GetEnterpriseModel getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(GetEnterpriseModel enterprise) {
        this.enterprise = enterprise;
    }
}
