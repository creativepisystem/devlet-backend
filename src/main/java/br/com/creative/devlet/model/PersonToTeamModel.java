package br.com.creative.devlet.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PersonToTeamModel {
    @NotNull
    @Positive
    private Long idPerson;
    @NotNull
    @Positive
    private Long idTeam;


    public PersonToTeamModel(Long idPerson, Long idTeam) {
        this.idPerson = idPerson;
        this.idTeam = idTeam;
    }

    public PersonToTeamModel() {
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }
}
