package ipz.healthservice.repositories;

import ipz.healthservice.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOfficeRepository extends JpaRepository<Office, Long> {
}
