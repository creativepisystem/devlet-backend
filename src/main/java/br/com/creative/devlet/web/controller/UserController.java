package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.PostUserModel;
import br.com.creative.devlet.model.PostUserPFModel;
import br.com.creative.devlet.model.PostUserPJModel;
import br.com.creative.devlet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController extends  BaseController{
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
        }catch(BussinessException e){
            return  getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }
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
//        userService.deleteUser(id);
    }

}
