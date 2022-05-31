package ipz.healthservice.services;

import com.netflix.discovery.converters.Auto;
import ipz.healthservice.models.Doctor;
import ipz.healthservice.models.Patient;
import ipz.healthservice.models.Visit;
import ipz.healthservice.models.VisitKey;
import ipz.healthservice.repositories.IDoctorRepository;
import ipz.healthservice.repositories.IPatientRepository;
import ipz.healthservice.repositories.IVisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Date;
import java.util.List;

@Service
public class VisitService {
    Logger logger = LoggerFactory.getLogger("Visit service logger: ");
    IVisitRepository iVisitRepository;
    IDoctorRepository iDoctorRepository;
    IPatientRepository iPatientRepository;

    @Autowired
    public VisitService(IVisitRepository iVisitRepository,
                        IDoctorRepository iDoctorRepository,
                        IPatientRepository iPatientRepository) {
        this.iVisitRepository = iVisitRepository;
        this.iDoctorRepository = iDoctorRepository;
        this.iPatientRepository = iPatientRepository;
    }

    public Visit addVisit(Visit visit) {
        return iVisitRepository.save(visit);
    }

    public Visit addVisitByIds(Long patientId, Long doctorId, Date date) {
        Patient patient = iPatientRepository.findById(patientId).get();
        Doctor doctor = iDoctorRepository.findById(doctorId).get();
        Visit visit = new Visit(patient, doctor, date);
        logger.info(patient.getLastName());
        logger.info(doctor.getLastName());
        return addVisit(visit);
    }

//    public Visit addVisitByPatientIdAndDoctorId(Long patientId, Long doctorId, Date date) {
//        return addVisit(new Visit(patientId, doctorId, date));
//    }

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
