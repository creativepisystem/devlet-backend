package br.com.creative.devlet.web.controller;

import br.com.creative.devlet.enums.EnumResponseType;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetTeamModel;
import br.com.creative.devlet.model.PersonToTeamModel;
import br.com.creative.devlet.model.TeamModel;
import br.com.creative.devlet.security.SecurityUser;
import br.com.creative.devlet.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/team")
public class TeamController extends BaseController {
    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public List<GetTeamModel> getTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeam(@PathVariable Long id) {
        try {
            GetTeamModel team = teamService.findById(id);
            return new ResponseEntity<GetTeamModel>(team, HttpStatus.OK);
        } catch (BussinessException e) {
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        } catch (Exception e) {
            return getResponse(e.getMessage(), EnumResponseType.UNKNOWN_ERROR);
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<?> createTeam(@Valid @RequestBody TeamModel team, BindingResult validation, @AuthenticationPrincipal SecurityUser user) {
        if (validation.hasErrors()) {
            return getErrorsResponse(validation);
        } else {
            try {
                return new ResponseEntity<>(teamService.create(team, user), HttpStatus.OK);
            } catch (BussinessException e) {
                return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
            } catch (Exception e) {
                return getResponse(e.getMessage(), EnumResponseType.UNKNOWN_ERROR);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @Valid @RequestBody TeamModel team, @AuthenticationPrincipal SecurityUser user, BindingResult validation) {
        if (validation.hasErrors()) {
            return new ResponseEntity<>(validation.getFieldErrors(), HttpStatus.EXPECTATION_FAILED);
        } else {
            try {
                team.setId(id);
                return new ResponseEntity<>(teamService.update(team, user), HttpStatus.OK);
            } catch (BussinessException e) {
                return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
            } catch (Exception e) {
                return getResponse(e.getMessage(), EnumResponseType.UNKNOWN_ERROR);
            }
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id, @AuthenticationPrincipal SecurityUser user) {
        try {
            teamService.delete(id, user);
            return getResponse("Team deleted successfully", EnumResponseType.SUCCESS);
        } catch (BussinessException e) {
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        } catch (Exception e) {
            return getResponse(e.getMessage(), EnumResponseType.UNKNOWN_ERROR);
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{idTeam}/add-person/{idPerson}")
    public ResponseEntity<?> addPersonIntoTeam(@PathVariable("idTeam") Long idTeam, @PathVariable("idPerson") Long idPerson, @AuthenticationPrincipal SecurityUser user) {
        PersonToTeamModel model = new PersonToTeamModel(idPerson, idTeam);
        try {
            teamService.addPersonToTeam(model, user);
            return getResponse("Person added successfully ", EnumResponseType.SUCCESS);
        } catch (BussinessException e) {
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        } catch (Exception e) {
            return getResponse(e.getMessage(), EnumResponseType.UNKNOWN_ERROR);
        }
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idTeam}/remove-person/{idPerson}")
    public ResponseEntity<?> removePersonFromTeam(@PathVariable("idTeam") Long idTeam, @PathVariable("idPerson") Long idPerson, @AuthenticationPrincipal SecurityUser user) {
        PersonToTeamModel model = new PersonToTeamModel(idPerson, idTeam);
        try {
            teamService.removePersonFromTeam(model, user);
            return getResponse("Person removed successfully", EnumResponseType.SUCCESS);
        } catch (BussinessException e) {
            return getResponse(e.getMessage(), EnumResponseType.BUSSINESS_EXCEPTION);
        } catch (Exception e) {
            return getResponse(e.getMessage(), EnumResponseType.UNKNOWN_ERROR);
        }
    }


    /*
     * TODO
     * adicionar chave estrangeira da empresa para o time X
     * adicionar campo relativo na Entidade (Team e Empresa) X
     *
     * Buscar o usuario (verificar linha 86 AuthenticationController) X
     *
     * pegar empresa do usuario X
     * verificar se time e usuario sao da mesma empresa X
     *
     * verificar se usuario e person sao da mesma empresa X
     *
     * adiconar anotação de hasHole pra segunça(ADMIN,MANAGER) X
     * */
}
