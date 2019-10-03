package br.com.creative.devlet.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/location")
public class LocationController{
    @Autowired
    private MessageSource messageSource;

    @PostMapping("/{language}")
    public ResponseEntity<?> changeLanguage(@PathVariable("language") String language){

        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
