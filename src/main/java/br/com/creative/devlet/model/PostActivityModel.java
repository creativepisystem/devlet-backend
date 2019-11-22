package br.com.creative.devlet.model;

import java.util.Date;
import java.util.List;

public class PostActivityModel {
    private String title;
    private String description;
    private Date openingDate;
    private Date conclusionDate;
    private List<CheckListModel> checkList;
    private Long personId;
    private Long stageId;

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

    public List<CheckListModel> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<CheckListModel> checkList) {
        this.checkList = checkList;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
}
