package ipz.healthservice.services;

import ipz.healthservice.models.Doctor;
import ipz.healthservice.repositories.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    IDoctorRepository iDoctorRepository;

    @Autowired
    public DoctorService(IDoctorRepository iDoctorRepository) {
        this.iDoctorRepository = iDoctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        return iDoctorRepository.save(doctor);
    }

    public List<Doctor> findAllByBranchId(Long id) {
        return iDoctorRepository.findAllByBranchId(id);
    }
}
