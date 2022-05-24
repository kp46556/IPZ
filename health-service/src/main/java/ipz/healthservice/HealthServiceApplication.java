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
			VisitService visitService) {
		return (args) -> {
			Hospital milHospital = new Hospital("name1", "addr1", "Military", 14.223, 32.333);
			Patient patient1 = new Patient("Patient", "Patientski", "00u55mrhpeBbCP3aa5d7");
			Branch milHospitalBranch1 = new Branch("Kardiologia", milHospital);
			Branch milHospitalBranch2 = new Branch("Onkologia", milHospital);
			Doctor doctor1 = new Doctor("Doctor", "Doctorski", "00u55mt60r3EYoghq5d7", milHospitalBranch1);
			Visit visit = new Visit(patient1, doctor1, new Date());
			hospitalService.addHospital(milHospital);
			hospitalService.addHospital(new Hospital("name2", "addr2", "Public", 33.441, 55.551));
			hospitalService.addHospital(new Hospital("name3", "addr3", "Public", 13.4445, 14.44));
			hospitalService.addHospital(new Hospital("name4", "addr4", "Rehab", 10.44, 17.11));
			branchService.addBranch(milHospitalBranch1);
			branchService.addBranch(milHospitalBranch2);
			doctorService.addDoctor(doctor1);
			patientService.addPatient(patient1);
			visitService.addVisit(visit);
		};
	}
}
