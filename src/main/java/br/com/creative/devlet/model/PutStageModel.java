package br.com.creative.devlet.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class PutStageModel {
    @Null(message = "This field must be empty")
    private Long id;
    @NotBlank(message = "The stage name can't be empty")
    @Size(min = 3, max = 50, message = "The stage name must be within 3 and 50 characters")
    private String name;
    @NotBlank(message = "The stage description can't be empty")
    @Size(min = 3, max = 150, message = "The stage description must be within 3 and 150 characters")
    private String description;
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
}
