package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetProjectModel;
import br.com.creative.devlet.model.PostProjectModel;
import br.com.creative.devlet.security.SecurityUser;
import br.com.creative.devlet.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/project")
public class ProjectController extends BaseController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<GetProjectModel> getProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProject(@PathVariable Long id) {
        try {
            GetProjectModel project = projectService.findById(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (BussinessException e) {
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createProject(@Valid @RequestBody PostProjectModel model, BindingResult validation, @AuthenticationPrincipal SecurityUser user){
        if(validation.hasErrors()){
            return getErrorsResponse(validation);
        }else {
            try {
                return new ResponseEntity<>(projectService.create(model, user),HttpStatus.OK);
            }catch (BussinessException e){
                return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
            }catch (Exception e){
                return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Long id,@Valid @RequestBody PostProjectModel model, BindingResult validation,@AuthenticationPrincipal SecurityUser user){
        if (validation.hasErrors()){
            return getErrorsResponse(validation);
        }else {
            try {
                model.setId(id);
                return new ResponseEntity<>(projectService.update(model,user),HttpStatus.OK);
            }catch (BussinessException e){
                return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
            }catch (Exception e){
                return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id,@AuthenticationPrincipal SecurityUser user){
        try {
            projectService.delete(id,user);
            return getResponse("Project removed successfully",EnumResponseType.SUCCESS);
        }catch (BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }
}
