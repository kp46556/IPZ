package ipz.gatewayservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findDoctorByOktaUID(String oktaUID);
}
