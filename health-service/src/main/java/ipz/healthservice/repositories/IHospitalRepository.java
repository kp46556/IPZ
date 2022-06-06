package ipz.healthservice.repositories;

import ipz.healthservice.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findById(long id);
    Optional<Hospital> findHospitalByName(String name);
}
