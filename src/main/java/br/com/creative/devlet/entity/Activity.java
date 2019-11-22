package br.com.creative.devlet.entity;

import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.model.CheckListModel;
import br.com.creative.devlet.util.HashMapConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(insertable = false,columnDefinition = "varchar(50) default 'CLOSED' not null")
    private EnumActivityStatus status;

    @Column(name = "opening_date", insertable = false)
    private Date openingDate;

    @Column(name = "conclusion_date", insertable = false)
    private Date conclusionDate;

    @Column
    @Convert(converter = HashMapConverter.class)
    private List<CheckListModel> checklist;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;


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

    public List<CheckListModel> getChecklist() {
        return checklist;
    }

    public void setChecklist(List<CheckListModel> checklist) {
        this.checklist = checklist;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
