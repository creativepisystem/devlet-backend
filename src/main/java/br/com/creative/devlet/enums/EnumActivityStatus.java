package br.com.creative.devlet.enums;

public enum EnumActivityStatus {
    OPEN("open"),
    CLOSED("closed"),
    COMPLETED("completed"),
    REVISION("awaiting revision");

    private String name;

    EnumActivityStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
