package br.com.creative.devlet.model;

import br.com.creative.devlet.validations.Empty;
import br.com.creative.devlet.validations.Length;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePasswordModel {
    @Empty(message = "Old Password don't can be empty")
    private String oldPassword;
    @Length(min = 8,max = 14,message = "Password must have between 8 and 14 characters")
    private String newPassword;
    @Length(min = 8,max = 14,message = "Password must have between 8 and 14 characters")
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
