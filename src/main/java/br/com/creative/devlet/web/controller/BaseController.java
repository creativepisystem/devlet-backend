package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    private SecurityUtils securityUtils;
    public User getCurrentUser(){
        return securityUtils.getLoginUser();
    }

}
