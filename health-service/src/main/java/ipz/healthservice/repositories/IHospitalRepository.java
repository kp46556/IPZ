package ipz.healthservice.repositories;

import ipz.healthservice.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findById(long id);
    Optional<Hospital> findHospitalByName(String name);
}
