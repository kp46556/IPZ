package ipz.healthservice.repositories;

import ipz.healthservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllByBranchId(Long id);
}
