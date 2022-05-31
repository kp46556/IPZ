package ipz.gatewayservice.repositories;

import ipz.gatewayservice.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByOktaUID(String oktaUID);
}
