package ipz.healthservice.services;

import com.netflix.discovery.converters.Auto;
import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitKey;
import ipz.healthservice.repositories.IVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Visit> findByVisitKeyPatientId(Long id) {
        return iVisitRepository.findByVisitKeyPatientId(id);
    }

    public List<Visit> findByVisitKeyDoctorId(Long id) {
        return iVisitRepository.findByVisitKeyDoctorId(id);
    }

    public List<Visit> findAllByVisitKey(Long patientId, Long doctorId) {
        return iVisitRepository.findAllByVisitKey(new VisitKey(patientId, doctorId));
    }
}
