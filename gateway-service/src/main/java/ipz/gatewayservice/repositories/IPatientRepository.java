package ipz.gatewayservice.repositories;

import ipz.gatewayservice.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Autowired
    Patient findPatientByOktaUID(String oktaUID);
}
