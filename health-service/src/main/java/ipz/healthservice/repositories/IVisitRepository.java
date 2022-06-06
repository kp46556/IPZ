package ipz.healthservice.repositories;

import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IVisitRepository extends JpaRepository<Visit, VisitKey> {
    List<Visit> findByVisitKeyPatientId(Long id);
    List<Visit> findByVisitKeyDoctorId(Long id);
    List<Visit> findAllByVisitKey(VisitKey visitKey);
}
