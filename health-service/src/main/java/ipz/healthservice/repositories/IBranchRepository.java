package ipz.healthservice.repositories;

import ipz.healthservice.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findAllByHospital_Id(Long hospitalId);
}
