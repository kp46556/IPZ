package ipz.healthservice.repositories;

import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitRepository extends JpaRepository<Visit, VisitKey> {

}
