package ipz.healthservice.controllers;

import ipz.healthservice.models.Office;
import ipz.healthservice.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-service/office")
public class OfficeController {
    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("")
    public String works() {
        return "office works!";
    }

    @GetMapping("findAll")
    public List<Office> findAll() {
        return officeService.findAll();
    }

    @PostMapping("addOffice")
    public Office addOffice(@RequestBody Office office) {
        return officeService.addOffice(office);
    }
}
