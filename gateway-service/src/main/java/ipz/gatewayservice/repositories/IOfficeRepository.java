package ipz.gatewayservice.repositories;

import ipz.gatewayservice.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfficeRepository extends JpaRepository<Office, Long> {
}
