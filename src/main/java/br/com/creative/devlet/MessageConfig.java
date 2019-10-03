package br.com.creative.devlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;

@Configuration
public class MessageConfig {

    @Autowired
    private HttpSession session;

    @Autowired
    private MessageSource messageSource;

    public MessageConfig(){

    }
}
