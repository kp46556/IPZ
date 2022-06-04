package ipz.gatewayservice.repositories;

import ipz.gatewayservice.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Long> {
}
