package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.entity.User;
import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.*;
import br.com.creative.devlet.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/users")
public class UserController extends  BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    Logger log;

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        log.info("process=get-user, user_id={}", id);
        Optional<User> user = userService.getUserById(id);
        return user.map( u -> ResponseEntity.ok(u))
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pj")
    public ResponseEntity<?> createUserPJ(@Valid @RequestBody PostUserPJModel model, BindingResult validation) throws BussinessException {
        if(validation.hasErrors()){
            return getErrorsResponse(validation);
        }
        try{
            userService.createUserPJ(model);
            return getResponse("User created succesfully", EnumResponseType.CREATED);
        }catch(BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }
    @PostMapping("/pf")
    public ResponseEntity<?> createUserPF(@Valid @RequestBody PostUserPFModel model, BindingResult validation) throws BussinessException {
        if(validation.hasErrors()){
            return getErrorsResponse(validation);
        }
        try{
            userService.createUserPF(model);
            return getResponse("User created succesfully", EnumResponseType.CREATED);
        }catch(BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody PostUserModel model,BindingResult validation) {
        if(validation.hasErrors()){
            return getErrorsResponse(validation);
        }
//        try{
//            userService.updateUser(model);
//            return getResponse("User created succesfully", EnumResponseType.SUCCESS);
//        }catch(BussinessException e){
//            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
//        }catch (Exception e){
//            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
//        }
        return getResponse("",EnumResponseType.SUCCESS);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("process=delete-user, user_id={}", id);
        userService.deleteUser(id);
    }

}
