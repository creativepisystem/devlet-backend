package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.TeamModel;
import br.com.creative.devlet.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/team")
public class TeamController extends BaseController {
    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public List<Team> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeam(@PathVariable Long id) {
        Optional<Team> team = teamService.findById(id);
        return team.map(e -> ResponseEntity.ok(e))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<?> createTeam(@Valid @RequestBody TeamModel team, BindingResult validation) {
        if (validation.hasErrors()) {
            return getErrorsResponse(validation);
        } else {
            try {
                return new ResponseEntity<>(teamService.create(team), HttpStatus.OK);
            } catch (BussinessException e) {
                return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamModel team, BindingResult validation) {
        if (validation.hasErrors()) {
            return new ResponseEntity<>(validation.getFieldErrors(), HttpStatus.EXPECTATION_FAILED);
        } else {
            try {
                team.setId(id);
                return new ResponseEntity<>(teamService.update(team),HttpStatus.OK);
            }catch (BussinessException e){
                return getResponse(e.getMessage(),EnumResponseType.BUSSINESS_EXCEPTION);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
    }
}
