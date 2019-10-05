package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.config.MessageConfig;
import br.com.creative.devlet.enums.EnumAttributes;
import br.com.creative.devlet.enums.EnumLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@RestController
@RequestMapping("api/location")
public class LocationController{
    @Autowired
    private HttpSession session;
    @Autowired
    private MessageConfig messageConfig;

    @PostMapping("/{language}")
    public ResponseEntity<?> changeLanguage(@PathVariable("language") String language){
        session.setAttribute(EnumAttributes.LANGUAGE.name(),language);
        Locale.setDefault(EnumLanguage.getLocaleByName(language));
        return new ResponseEntity<String>(messageConfig.getMessage("hello"), HttpStatus.OK);
    }
}
