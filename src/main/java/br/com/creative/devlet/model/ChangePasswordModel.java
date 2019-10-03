package br.com.creative.devlet.model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ChangePasswordModel {
    @NotEmpty
    private String oldPassword;
    @NotEmpty
    @Size(min=8,max=14)
    private String newPassword;
    @NotEmpty
    @Size(min=8,max=14)
    private String confirmNewPassword;

    public ChangePasswordModel() {
    }

    public ChangePasswordModel(String oldPassword, String newPassword, String confirmNewPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
