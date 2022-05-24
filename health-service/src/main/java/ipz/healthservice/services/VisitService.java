package ipz.healthservice.services;

import ipz.healthservice.models.Visit;
import ipz.healthservice.repositories.IVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    IVisitRepository iVisitRepository;

    @Autowired
    public VisitService(IVisitRepository iVisitRepository) {
        this.iVisitRepository = iVisitRepository;
    }

    public Visit addVisit(Visit visit) {
        return iVisitRepository.save(visit);
    }
}
