package ipz.healthservice.services;

import ipz.healthservice.models.Hospital;
import ipz.healthservice.repositories.IHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    private IHospitalRepository iHospitalRepository;

    public Hospital addHospital(Hospital hospital) {
        return iHospitalRepository.save(hospital);
    }

    public List<Hospital> getAllHospitals() {
        return iHospitalRepository.findAll();
    }
}
