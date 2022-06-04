package ipz.gatewayservice.repositories;

import ipz.gatewayservice.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    @Autowired
    Doctor findDoctorByOktaUID(String oktaUID);
}
