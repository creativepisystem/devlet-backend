package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.model.GetStageModel;
import br.com.creative.devlet.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
