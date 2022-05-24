package ipz.healthservice.services;

import ipz.healthservice.models.Branch;
import ipz.healthservice.repositories.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
