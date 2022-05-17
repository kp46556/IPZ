package ipz.healthservice.controllers;

import ipz.healthservice.models.Hospital;
import ipz.healthservice.repositories.IHospitalRepository;
import ipz.healthservice.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/health-service")
public class HealthServiceController {
    @GetMapping("")
    public String healthService() {
        return "health-service works";
    }
}
