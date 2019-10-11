package br.com.creative.devlet.validations;

public class ValidationTestModel {
    
    @Cpf
    private String cpf;
    @Cnpj
    private String cnpj;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
