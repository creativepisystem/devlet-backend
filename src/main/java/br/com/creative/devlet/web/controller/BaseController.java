package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.ResponseModel;
import br.com.creative.devlet.model.ValidationErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    public ResponseEntity<List<ValidationErrorModel>> getErrorsResponse(BindingResult validation){
        List<ValidationErrorModel> errors = new ArrayList<>();
        for(FieldError error : validation.getFieldErrors()){
            ValidationErrorModel model = new ValidationErrorModel();
            model.setField(error.getField());
            model.setErrorMessage(error.getDefaultMessage());
            errors.add(model);
        }
        return new ResponseEntity<>(errors, HttpStatus.EXPECTATION_FAILED);
    }

    public ResponseEntity<ResponseModel> getResponse(String message,EnumResponseType type){

        ResponseModel model = new ResponseModel();
        model.setType(type.getName());
        model.setMessage(message);
        return new ResponseEntity<>(model,getStatusResponse(type));
    }
    private HttpStatus getStatusResponse(EnumResponseType type){
        switch (type){
            case BUSSINESS_EXCEPTION:
            case FIELD_ERROR:
                return HttpStatus.EXPECTATION_FAILED;
            case UNKNOWN_ERROR:
                return HttpStatus.INTERNAL_SERVER_ERROR;
            case SUCCESS:
            default:
                return HttpStatus.OK;
        }
    }

}
