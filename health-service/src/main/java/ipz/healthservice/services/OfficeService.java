package ipz.healthservice.services;

import ipz.healthservice.models.Office;
import ipz.healthservice.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    private IOfficeRepository iOfficeRepository;

    @Autowired
    public OfficeService(IOfficeRepository iOfficeRepository) {
        this.iOfficeRepository = iOfficeRepository;
    }

    public Office addOffice(Office office) {
        return iOfficeRepository.save(office);
    }

    public List<Office> findAll() {
        return iOfficeRepository.findAll();
    }
}
