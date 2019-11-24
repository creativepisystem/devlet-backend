package br.com.creative.devlet.model;

import java.util.Date;
import java.util.List;

public class PutActivityModel {
    private Long id;
    private String title;
    private String description;
    private Date openingDate;
    private Date conclusionDate;
    private CheckListModel checkList;
    private Long stageId;
    private Long personId;

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

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
