package ipz.healthservice.repositories;

import ipz.healthservice.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranchRepository extends JpaRepository<Branch, Long> {
}
