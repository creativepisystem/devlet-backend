package br.com.creative.devlet.model;

import br.com.creative.devlet.enums.EnumTypeUser;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserAndPersonModel {
    private Long id;
    @NotBlank(message = "Username can't be empty")
    @Size(min = 3, max = 50, message = "Username must be within 3 and 50 characters")
    private String username;
    @NotBlank(message = "Password can't be empty")
    @Size(min = 8,max = 14, message = "Password must be within 8 and 14 characters")
    private String password;
    @NotBlank(message = "Password can't be empty")
    @Size(min = 8,max = 14, message = "confirmPassword must be within 8 and 14 characters")
    private String confirmPassword;
    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email must be a valid email")
    private String email;
    @NotNull()
    private EnumTypeUser type;



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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumTypeUser getType() {
        return type;
    }

    public void setType(EnumTypeUser type) {
        this.type = type;
    }
}
