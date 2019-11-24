package br.com.creative.devlet.model;

import br.com.creative.devlet.enums.EnumActivityStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

public class GetActivityModel {
    private Long id;
    private String title;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private EnumActivityStatus status;
    private Date openingDate;
    private Date conclusionDate;
    private CheckListModel checkList;
    private GetPersonModel person;
    private GetStageModel stage;
    private GetEnterpriseModel enterprise;

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

    public EnumActivityStatus getStatus() {
        return status;
    }

    public void setStatus(EnumActivityStatus status) {
        this.status = status;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public CheckListModel getCheckList() {
        return checkList;
    }

    public void setCheckList(CheckListModel checkList) {
        this.checkList = checkList;
    }

    public GetPersonModel getPerson() {
        return person;
    }

    public void setPerson(GetPersonModel person) {
        this.person = person;
    }

    public GetStageModel getStage() {
        return stage;
    }

    public void setStage(GetStageModel stage) {
        this.stage = stage;
    }

    public GetEnterpriseModel getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(GetEnterpriseModel enterprise) {
        this.enterprise = enterprise;
    }
}
