package br.com.creative.devlet.model;

import br.com.creative.devlet.validations.Cpf;

public class PostUserPFModel extends PostUserModel {
    @Cpf
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
