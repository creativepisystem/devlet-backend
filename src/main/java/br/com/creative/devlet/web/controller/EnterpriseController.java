package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.EnterprisePostModel;
import br.com.creative.devlet.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController extends BaseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("")
    public ResponseEntity<?> getEnterprises() {
        List<Enterprise> enterprises = enterpriseService.findAll();
        return new ResponseEntity<>(enterprises,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long id) {
        Optional<Enterprise> enterprise = enterpriseService.findById(id);
        return enterprise.map(e -> ResponseEntity.ok(e))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> createEnterprise(@Valid @RequestBody EnterprisePostModel enterprise, BindingResult validation) {
        if (validation.hasErrors()) {
            return getErrorsResponse(validation);
        } else {
            try {
                return new ResponseEntity<>(enterpriseService.create(enterprise), HttpStatus.CREATED);
            } catch (BussinessException e) {
                return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnterprise(@PathVariable Long id, @Valid @RequestBody EnterprisePostModel enterprise, BindingResult validation) {
        if (validation.hasErrors()) {
            return getErrorsResponse(validation);
        } else {
            try {
                enterprise.setId(id);
                return new ResponseEntity<>(enterpriseService.update(enterprise), HttpStatus.OK);
            } catch (BussinessException e) {
                return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEnterprise(@PathVariable Long id) {
        enterpriseService.delete(id);
    }

}
