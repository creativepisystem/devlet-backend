package br.com.creative.devlet.enums;

import java.util.Locale;

public enum EnumLanguage {

    PT("pt", new Locale("pt","BR")),ES("es", Locale.US);

    private String language;
    private Locale locale;
    EnumLanguage(String language,Locale locale){
        this.language= language;
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public Locale getLocale() {
        return locale;
    }

    public static Locale getLocaleByName(String language) {
        for(EnumLanguage enumLanguage: EnumLanguage.values()){
            if( language.equals(enumLanguage.getLanguage())){
                return enumLanguage.getLocale();
            }
        }
        return  null;
    }
}
