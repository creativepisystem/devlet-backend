package br.com.creative.devlet.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PostStageModel {
    @NotBlank(message = "The stage name can't be empty")
    @Size(min = 3, max = 50, message = "The stage name must be within 3 and 50 characters")
    private String name;
    @Size(min = 4, max = 350, message = "The stage description must be within 4 and 350 characters")
    private String description;
    @NotNull(message = "The project id can't be null")
    @Positive(message = "The project id must be positive")
    private Long projectId;

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
