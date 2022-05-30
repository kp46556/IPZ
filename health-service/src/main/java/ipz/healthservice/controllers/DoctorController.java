package ipz.healthservice.controllers;

import ipz.healthservice.models.Doctor;
import ipz.healthservice.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/health-service/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("")
    public String works() {
        return "doctor works";
    }

    @GetMapping("findAllByBranchId/{id}")
    public List<Doctor> findAllByBranchId(@PathVariable Long id) {
        return doctorService.findAllByBranchId(id);
    }

}
