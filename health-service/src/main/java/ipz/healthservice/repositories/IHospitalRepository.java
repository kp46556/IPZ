package ipz.healthservice.repositories;

import ipz.healthservice.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findById(long id);
}
