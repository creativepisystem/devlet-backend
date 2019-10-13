package br.com.creative.devlet.config;

import br.com.creative.devlet.enums.EnumAttributes;
import br.com.creative.devlet.enums.EnumLanguage;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class MessageConfig {

    private MessageSource messageSource;

    public MessageConfig(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public String getMessage(String message){
       return messageSource.getMessage(message,null, Locale.getDefault());
    }
}