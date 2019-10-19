package br.com.creative.devlet.util;

public class Utils {

    public static String removeMask(String value){
        return value.replaceAll("[^0-9]","");
    }
}
