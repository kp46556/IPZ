package ipz.healthservice.controllers;

import ipz.healthservice.models.Branch;
import ipz.healthservice.models.Hospital;
import ipz.healthservice.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/health-service/branch")
public class BranchController {
    @Autowired
    BranchService branchService;

    @GetMapping("findAllByHospital_Id/{id}")
    public List<Branch> findAllByHospital_Id(@PathVariable Long id) {
        return branchService.findAllByHospital_Id(id);
    }
}
