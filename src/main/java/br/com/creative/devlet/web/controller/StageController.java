package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetStageModel;
import br.com.creative.devlet.model.PostStageModel;
import br.com.creative.devlet.model.PutStageModel;
import br.com.creative.devlet.security.SecurityUser;
import br.com.creative.devlet.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/stage")
public class StageController extends BaseController {
    @Autowired
    private StageService stageService;

    @GetMapping("")
    public ResponseEntity<?> getStages() {
        List<GetStageModel> stageModels = stageService.findAll();
        return new ResponseEntity<>(stageModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStage(@PathVariable Long id){
        try {
            GetStageModel stageModel = stageService.findById(id);
            return new ResponseEntity<>(stageModel,HttpStatus.OK);
        }catch (BussinessException e){
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @GetMapping("/project-stages/{projectId}")
    public ResponseEntity<?> getStagesOfProject(@PathVariable Long projectId){
        try {
            List<GetStageModel> stageModels = stageService.findStagesOfProject(projectId);
            return new ResponseEntity<>(stageModels,HttpStatus.OK);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createStage(@Valid @RequestBody PostStageModel model, BindingResult validation, @AuthenticationPrincipal SecurityUser user){
        if (validation.hasErrors()){
            return getErrorsResponse(validation);
        }else {
            try {
                return new ResponseEntity<>(stageService.create(model, user),HttpStatus.OK);
            }catch (BussinessException e){
                return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
            }catch (Exception e){
                return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStage(@PathVariable Long id, @Valid @RequestBody PutStageModel model,BindingResult validation,@AuthenticationPrincipal SecurityUser user){
        if (validation.hasErrors()){
            return getErrorsResponse(validation);
        }else {
            try {
                model.setId(id);
                return new ResponseEntity<>(stageService.update(model,user),HttpStatus.OK);
            }catch (BussinessException e){
                return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
            }catch (Exception e){
                return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStage(@PathVariable Long id, @AuthenticationPrincipal SecurityUser user){
        try {
            stageService.delete(id,user);
            return getResponse("Stage deleted successfully",EnumResponseType.SUCCESS);
        }catch (BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }
}
