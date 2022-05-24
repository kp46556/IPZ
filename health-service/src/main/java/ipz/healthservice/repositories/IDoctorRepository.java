package ipz.healthservice.repositories;

import ipz.healthservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
}
