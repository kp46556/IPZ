package ipz.healthservice.repositories;

import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVisitRepository extends JpaRepository<Visit, VisitKey> {
    List<Visit> findByVisitKeyPatientId(Long id);
    List<Visit> findByVisitKeyDoctorId(Long id);
    List<Visit> findAllByVisitKey(VisitKey visitKey);
}
