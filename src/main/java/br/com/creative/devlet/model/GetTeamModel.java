package br.com.creative.devlet.model;

import java.util.List;

public class GetTeamModel {

    private Long id;
    private String name;
    private GetEnterpriseModel enterprise;
    private List<GetPersonModel> people;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public List<GetPersonModel> getPeople() {
        return people;
    }

    public void setPeople(List<GetPersonModel> people) {
        this.people = people;
    }

    public GetEnterpriseModel getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(GetEnterpriseModel enterprise) {
        this.enterprise = enterprise;
    }
}
