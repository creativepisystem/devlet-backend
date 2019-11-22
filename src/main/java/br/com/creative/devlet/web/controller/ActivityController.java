package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetActivityModel;
import br.com.creative.devlet.model.PostActivityModel;
import br.com.creative.devlet.model.PutActivityModel;
import br.com.creative.devlet.security.SecurityUser;
import br.com.creative.devlet.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/activity")
public class ActivityController extends BaseController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("")
    public ResponseEntity<?> getActivities(){
        List<GetActivityModel> activityModels = activityService.findAll();
        return new ResponseEntity<>(activityModels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivity(@PathVariable Long id){
        try {
            GetActivityModel activityModel = activityService.findById(id);
            return new ResponseEntity<>(activityModel,HttpStatus.OK);
        }catch (BussinessException e){
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @GetMapping("/{owner}/activities/{id}")
    public ResponseEntity<?> getActivitiesOfPerson(@PathVariable String owner,@PathVariable Long id){
        List<GetActivityModel> activityModels;
        try {
            if(owner.equals("person")) {
                activityModels = activityService.findActivitiesOfPerson(id);
            }else {
                activityModels = activityService.findActivitiesOfStage(id);
            }
            return new ResponseEntity<>(activityModels,HttpStatus.OK);
        }catch (BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createActivity(@Valid @RequestBody PostActivityModel model, BindingResult validation, @AuthenticationPrincipal SecurityUser user){
        if(validation.hasErrors()){
            return getErrorsResponse(validation);
        }else try {
            return new ResponseEntity<>(activityService.create(model, user),HttpStatus.OK);
        }catch (BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable Long id, @Valid @RequestBody PutActivityModel model,BindingResult validation,@AuthenticationPrincipal SecurityUser user){
        if(validation.hasErrors()){
            return getErrorsResponse(validation);
        }else try {
            model.setId(id);
            return new ResponseEntity<>(activityService.update(model, user),HttpStatus.OK);
        }catch (BussinessException e){
            return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @PutMapping("/{status}/{id}")
    public ResponseEntity<?> updateActivityStatus(@PathVariable EnumActivityStatus status,@PathVariable Long id,@AuthenticationPrincipal SecurityUser user){
        try {
            activityService.updateActivityStatus(status, id, user);
            return getResponse("Activity status updated successfully",EnumResponseType.SUCCESS);
        }catch (BussinessException e){
            return  getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id,@AuthenticationPrincipal SecurityUser user){
        try {
            activityService.delete(id, user);
            return getResponse("Activity deleted successfully",EnumResponseType.SUCCESS);
        }catch (BussinessException e){
            return  getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
        }catch (Exception e){
            return getResponse(e.getMessage(),EnumResponseType.UNKNOWN_ERROR);
        }
    }
}
