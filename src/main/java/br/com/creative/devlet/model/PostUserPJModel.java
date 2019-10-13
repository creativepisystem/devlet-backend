package br.com.creative.devlet.model;

import br.com.creative.devlet.validations.Cnpj;

public class PostUserPJModel extends PostUserModel {
    @Cnpj
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
