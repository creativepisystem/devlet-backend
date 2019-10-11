package br.com.creative.devlet.enums;

public enum EnumEnterpriseType {
    CLIENT("Client"),
    DEVELOPER("Developer");

    private String name;
    EnumEnterpriseType(String name){
        this.name = name;
    }

    public String getName(){
        return  name;
    }
}
