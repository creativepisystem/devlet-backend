package br.com.creative.devlet.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostUserModel {
    private Long id;
    @Email
    @Size(max=100)
    private String email;
    @NotBlank
    @Size(min = 5,max=20)
    private String username;
    @NotBlank
    @Size(min=8,max=14)
    private String password;
    @NotBlank
    @Size(min=8,max=14)
    private String confirmPassword;
    @NotBlank
    @Size(min = 2,max=40)
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
