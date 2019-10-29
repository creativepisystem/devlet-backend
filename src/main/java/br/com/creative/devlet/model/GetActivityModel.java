package br.com.creative.devlet.model;

import java.util.Date;

public class GetActivityModel {
    private Long id;
    private String title;
    private String description;
    private Date creationDate;
    private Date conclusionDate;
    private String content;
    private GetPersonModel personModel;
    private GetStageModel stageModel;
    private GetEnterpriseModel enterpriseModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GetPersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(GetPersonModel personModel) {
        this.personModel = personModel;
    }

    public GetStageModel getStageModel() {
        return stageModel;
    }

    public void setStageModel(GetStageModel stageModel) {
        this.stageModel = stageModel;
    }

    public GetEnterpriseModel getEnterpriseModel() {
        return enterpriseModel;
    }

    public void setEnterpriseModel(GetEnterpriseModel enterpriseModel) {
        this.enterpriseModel = enterpriseModel;
    }
}
