package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.model.EnterpriseModel;
import br.com.creative.devlet.service.EnterpriseService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enterprises")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private Logger log;

    @GetMapping("")
    public List<Enterprise> getEnterprises() {
        return enterpriseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterprise(@PathVariable Long id) {
        Optional<Enterprise> enterprise = enterpriseService.findById(id);
        return enterprise.map( e -> ResponseEntity.ok(e))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> createEnterprise(@Valid @RequestBody EnterpriseModel enterprise, BindingResult validation) {
        if(validation.hasFieldErrors()){
            return new ResponseEntity<>(validation.getFieldErrors(), HttpStatus.EXPECTATION_FAILED);
        }else{
            return new ResponseEntity<>(enterpriseService.create(enterprise), HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnterprise(@PathVariable Long id, @Valid @RequestBody EnterpriseModel enterprise,  BindingResult validation) {
        if(validation.hasFieldErrors()){
            return new ResponseEntity<>(validation.getFieldErrors(), HttpStatus.EXPECTATION_FAILED);
        }else{
            enterprise.setId(id);
            return new ResponseEntity<>(enterpriseService.update(enterprise), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        enterpriseService.delete(id);
    }

}
