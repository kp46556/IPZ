package ipz.healthservice.services;

import ipz.healthservice.models.Branch;
import ipz.healthservice.repositories.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    IBranchRepository iBranchRepository;

    @Autowired
    public BranchService(IBranchRepository iBranchRepository) {
        this.iBranchRepository = iBranchRepository;
    }

    public Branch addBranch(Branch branch) {
        return iBranchRepository.save(branch);
    }

    public List<Branch> findAllByHospital_Id(Long id) {
        return iBranchRepository.findAllByHospital_Id(id);
    }
}
