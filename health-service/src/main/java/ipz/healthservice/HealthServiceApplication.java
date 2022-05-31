package ipz.healthservice;

import ipz.healthservice.models.*;
import ipz.healthservice.repositories.IHospitalRepository;
import ipz.healthservice.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class HealthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthServiceApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner demo(
			HospitalService hospitalService,
			BranchService branchService,
			PatientService patientService,
			DoctorService doctorService,
			VisitService visitService,
			OfficeService officeService) {
		return (args) -> {
			Hospital blankHospital = new Hospital(1L, "BLANK", "BLANK", "BLANK", 0.0, 0.0);
			Hospital milHospital = new Hospital("109 Military Hospital SPZOZ", "Ks.Piotra Skargi 9/11, 71-422 Szczecin", "Military", 14.223, 32.333);
			Office officeBlank = new Office(1L, 0L);
			Office office1 = new Office(111L);
			Office office2 = new Office(222L);
			Office office3 = new Office(333L);
			Office office4 = new Office(444L);
			Patient patient1 = new Patient("Patient", "Patientski", "00u55mrhpeBbCP3aa5d7");
			Patient patient2 = new Patient("Patient2", "Patientski2", "00u57yxtq7FMVxTUK5d7");
			Branch blankBranch = new Branch(1L, "BLANK", blankHospital);
			Branch milHospitalBranch1 = new Branch("Cardiology", milHospital);
			Branch milHospitalBranch2 = new Branch("Oncology", milHospital);
			Doctor doctor1 = new Doctor("Doctor", "Doctorski", "00u55mt60r3EYoghq5d7", milHospitalBranch1, officeBlank);
			Doctor doctor2 = new Doctor("Doctor2", "Doctorski2", "00u57yygo2wC4YwcF5d7", milHospitalBranch1, officeBlank);
			Visit visit = new Visit(patient1, doctor1, new Date());
			Visit visit2 = new Visit(patient2, doctor1, new Date());
			Visit visit3 = new Visit(patient2, doctor2, new Date());
			hospitalService.addHospital(blankHospital);
			hospitalService.addHospital(milHospital);
			hospitalService.addHospital(new Hospital("Independent Public Regional Hospital", "Arkonska 4, 71-455 Szczecin", "Public", 33.441, 55.551));
			hospitalService.addHospital(new Hospital("Rehabilitation Hospital of St. Charles Borromeo", "aleja Wyzwolenia 52, 71-899 Szczecin", "Rehab", 13.4445, 14.44));
			hospitalService.addHospital(new Hospital("Independent Public Clinical Hospital No. 2", "al. Powstancow Wielkopolskich 72, 70-111 Szczecin", "Rehab", 10.44, 17.11));
			officeService.addOffice(officeBlank);
			officeService.addOffice(office1);
			officeService.addOffice(office2);
			officeService.addOffice(office3);
			officeService.addOffice(office4);
			branchService.addBranch(blankBranch);
			branchService.addBranch(milHospitalBranch1);
			branchService.addBranch(milHospitalBranch2);
			doctorService.addDoctor(doctor1);
			doctorService.addDoctor(doctor2);
			patientService.addPatient(patient1);
			patientService.addPatient(patient2);
			visitService.addVisit(visit);
			visitService.addVisit(visit2);
			visitService.addVisit(visit3);

		};
	}
}
