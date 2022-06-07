package ipz.gatewayservice.repositories;

import ipz.gatewayservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findDoctorByOktaUID(String oktaUID);
}
