package br.com.creative.devlet.model;

import javax.validation.constraints.*;
import java.util.Date;

public class PutStageModel {
    @Null(message = "This field must be empty")
    private Long id;
    @NotBlank(message = "The stage name can't be empty")
    @Size(min = 3, max = 50, message = "The stage name must be within 3 and 50 characters")
    private String name;
    @NotNull(message = "The project id can't be null")
    @Positive(message = "The project id must be positive")
    private String description;
    @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$",
            message = "The date must follow the mask: YYYY-MM-DD")
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
