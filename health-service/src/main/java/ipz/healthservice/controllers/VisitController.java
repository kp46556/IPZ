package ipz.healthservice.controllers;

import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitJsonPostDataModel;
import ipz.healthservice.models.VisitKey;
import ipz.healthservice.repositories.IVisitRepository;
import ipz.healthservice.services.HospitalService;
import ipz.healthservice.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-service/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("")
    public String works() {
        return "visit works";
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

    @PostMapping("addVisitByIds")
    public Visit addVisit(@RequestBody VisitJsonPostDataModel visitJsonPostDataModel)
    {
        return visitService.addVisitByIds(visitJsonPostDataModel.getPatientId(), visitJsonPostDataModel.getDoctorId(), visitJsonPostDataModel.getDate());
    }
}
