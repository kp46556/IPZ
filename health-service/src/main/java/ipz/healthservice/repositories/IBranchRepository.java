package ipz.healthservice.repositories;

import ipz.healthservice.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findAllByHospital_Id(Long hospitalId);
}
