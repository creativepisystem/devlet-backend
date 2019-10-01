package br.com.creative.devlet.enums;

public enum EnumResponseType {
    BUSSINESS_EXCEPTION("Bussiness Exception"),
    UNKNOWN_ERROR("Unknown Error"),
    FIELD_ERROR("Field Error"),
    SUCCESS("Success");

    private String name;
    EnumResponseType(String name){
        this.name = name;
    }

    public String getName(){
        return  name;
    }
}
