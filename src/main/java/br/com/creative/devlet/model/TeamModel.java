package br.com.creative.devlet.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class TeamModel {
    private Long id;
    @NotBlank(message = "Name can't be empty")
    @Size(min = 3, max = 50, message = "Name must be within 3 and 50 characters")
    private String name;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
