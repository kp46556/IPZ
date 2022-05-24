package ipz.healthservice.services;

import ipz.healthservice.models.Patient;
import ipz.healthservice.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    IPatientRepository iPatientRepository;

    @Autowired
    public PatientService(IPatientRepository iPatientRepository) {
        this.iPatientRepository = iPatientRepository;
    }

    public Patient addPatient(Patient patient) {
        return iPatientRepository.save(patient);
    }
}
