package ipz.healthservice.controllers;

import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitKey;
import ipz.healthservice.repositories.IVisitRepository;
import ipz.healthservice.services.HospitalService;
import ipz.healthservice.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-service/visits")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("")
    public String works() {
        return "visits works";
    }

    @GetMapping("getAllByVisitKey/{patientId}/{doctorId}")
    public List<Visit> getAll(@PathVariable Long patientId, @PathVariable Long doctorId) {
        return visitService.findAllByVisitKey(patientId, doctorId);
    }

    @GetMapping("getPatientVisitsById/{id}")
    public List<Visit> getPatientVisits(@PathVariable Long id) {
        return visitService.findByVisitKeyPatientId(id);
    }

    @GetMapping("getDoctorVisitsById/{id}")
    public List<Visit> getDoctorVisits(@PathVariable Long id) {
        return visitService.findByVisitKeyDoctorId(id);
    }

    @PostMapping("addVisit")
    public ResponseEntity addVisit(@RequestBody Visit visit)
    {
        visitService.addVisit(visit);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
