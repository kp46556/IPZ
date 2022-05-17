package ipz.healthservice.services;

import ipz.healthservice.exception.HospitalNotFoundException;
import ipz.healthservice.models.Hospital;
import ipz.healthservice.repositories.IHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private IHospitalRepository iHospitalRepository;

    public Hospital addHospital(Hospital hospital) {
        return iHospitalRepository.save(hospital);
    }

    public Hospital fullUpdateHospitalOrCreateIfNotExists(Long id, Hospital newHospital) {
        return iHospitalRepository.findById(id)
                .map(hospital -> {
                    hospital.setName(newHospital.getName());
                    hospital.setAddress(newHospital.getAddress());
                    hospital.setType(newHospital.getType());
                    return iHospitalRepository.save(hospital);
                })
                .orElseGet(() -> {
                    newHospital.setId(id);
                    return iHospitalRepository.save(newHospital);
                });
    }

    public void deleteHospitalById(Long id) { iHospitalRepository.deleteById(id); }

    public Hospital findHospitalByName(String name) {
        return iHospitalRepository.findHospitalByName(name)
                .orElseThrow(() -> new HospitalNotFoundException(name));
    }
    public List<Hospital> getAllHospitals() {
        return iHospitalRepository.findAll();
    }
}
