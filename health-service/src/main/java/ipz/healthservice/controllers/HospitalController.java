package ipz.healthservice.controllers;

import ipz.healthservice.models.Hospital;
import ipz.healthservice.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-service/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("")
    public String works() {
        return "hospital works";
    }

    @GetMapping("findAll")
    public List<Hospital> allHospitals() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping("getByName/{name}")
    public Hospital getHospitalByName(@PathVariable String name) {
        return hospitalService.findHospitalByName(name);
    }

    @PostMapping("create")
    public ResponseEntity createHospital(@RequestBody Hospital hospital) {
        hospitalService.addHospital(hospital);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("fullUpdateByIdOrCreateIfNotExists/{id}")
    public ResponseEntity fullUpdateHospitalOrCreateIfNotExists(@PathVariable Long id, @RequestBody Hospital hospital) {
        hospitalService.fullUpdateHospitalOrCreateIfNotExists(id, hospital);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity deleteHospitalById(@PathVariable Long id) {
        hospitalService.deleteHospitalById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
