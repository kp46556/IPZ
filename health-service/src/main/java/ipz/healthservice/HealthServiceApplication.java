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
			Hospital blankHospital = new Hospital(1L, "Centrum Onkologii Bydgoszcz im. prof. Franciszka Lukaszczyka","ul. Romanowskiej", "2", "Bydgoszcz", "85-796", "Public", 0.0, 0.0);
			Hospital milHospital = new Hospital("109 Military Hospital SPZOZ", "Ks.Piotra Skargi", "9/11", "Szczecin", "71-422", "Military", 14.223, 32.333);
			Hospital hos1=new Hospital("SP ZOZ Szpital Uniwersytecki w Krakowie", "ul. Kopernika", "36", "Krakow", "31-501", "Rehab", 13.4445, 14.44);
			Hospital hos2=new Hospital("Szpitale Pomorskie Sp. z o.o. Szpital Morski im. PCK", "ul. Powstania Styczniowego", "1", "Gdynia", "81-519", "Military", 10.44, 17.11);
			Hospital hos3=new Hospital("Wojewodzki Szpital Specjalistyczny im. Janusza Korczaka","ul. Hubalczykow","1","Slupsk","76-200", "Public",33.441, 55.551);
			Hospital hos4=new Hospital("Wojewodzki Szpital Specjalistyczny","ul. Terebelska", "57/65","Biala Podlaska","21-500","Public",14.223, 32.333);

			Office officeBlank = new Office(1L, 0L);
			Office office1 = new Office(111L);
			Office office2 = new Office(222L);
			Office office3 = new Office(333L);
			Office office4 = new Office(444L);
			Office office5 = new Office(555L);

			Patient patient1 = new Patient("Amelia", "Kaczmarczyk", "00u594cxk40j6OdK65d7");
			Patient patient2 = new Patient("Luiza", "Rutkowska", "00u594egqkd66AdHz5d7");
			Patient patient3 = new Patient("Ola", "Malinowska", "00u594ebfoMURCJsl5d7");
			Patient patient4 = new Patient("Irena", "Mazur", "00u594gih57EXeCRg5d7");
			Patient patient5 = new Patient("Andrea", "Gorska", "00u594ex2vmHOhziv5d7");
			Patient patient6 = new Patient("Aleksander", "Pawlak", "00u594f3zel4Txz5W5d7");
			Patient patient7 = new Patient("Ryszard", "Nowak", "00u594g73tbiC0Hqc5d7");
			Patient patient8 = new Patient("Konstanty", "Wisniewski", "00u594g7wsVFe27i05d7");
			Patient patient9 = new Patient("Roman", "Gorski", "00u594f8ncFBG5Ncr5d7");
			Patient patient10 = new Patient("Dorian", "Sikorski", "00u594fhmeN9UYZNw5d7");

			Branch blankBranch = new Branch(1L, "BLANK", blankHospital);
			Branch milHospitalBranch1 = new Branch("Kardiologia", milHospital);
			Branch milHospitalBranch2 = new Branch("Onkologia", milHospital);
			Branch milHospitalBranch3 = new Branch("Stomatologia",hos1);
			Branch milHospitalBranch4 = new Branch("Ginekologia", hos1);
			Branch milHospitalBranch5 = new Branch("Logopedia",hos2);
			Branch milHospitalBranch6 = new Branch("Ortopedia",hos2);
			Branch milHospitalBranch7 = new Branch("Chirurgia",hos3);
			Branch milHospitalBranch8 = new Branch("Endokrynologia",hos3);
			Branch milHospitalBranch9 = new Branch("Radiologia",hos4);
			Branch milHospitalBranch10 = new Branch("Psychologia",hos4);

			Doctor doctor1 = new Doctor("Doctor", "Doctorski","Chirurg", "00u55mrhpeBbCP3aa5d7", milHospitalBranch7, office4);
			Doctor doctor2 = new Doctor("Doctor2", "Doctorski2","Ortopeda", "00u57yxtq7FMVxTUK5d7", milHospitalBranch6, office1);
			Doctor doctor3 = new Doctor("Katarzyna","Piorkowska","Ortodonta","00u594jkvl0TD13mn5d7", milHospitalBranch3, office2);
			Doctor doctor4 = new Doctor("Adam","Sikorski","Psychiarta","00u594h68cVNUeK9g5d7",milHospitalBranch10, office2);
			Doctor doctor5 = new Doctor("Adam","Kobus","Psychiatra","00u594j66kMVHLYy25d7" ,milHospitalBranch10, office3);
			Doctor doctor6 = new Doctor("Magdalena","Szemryk","Ginekolog","00u594hd8nsgiT7Dq5d7", milHospitalBranch4, office2);
			Doctor doctor7 = new Doctor("Patrycja","Robok","Kardiolog","00u594j5jeGs14NGM5d7", milHospitalBranch1, office4);
			Doctor doctor8 = new Doctor("Emilia","Sobczak","Logopeda","00u594jkywKqQRjG75d7",milHospitalBranch5, office1);
			Doctor doctor9 = new Doctor("Alex","Wroblewski","Chirurg","00u594haxzMaewrDZ5d7", milHospitalBranch7, office5);
			Doctor doctor10 = new Doctor("Igor","Ziolkowski","Endokrynolog","00u594hup7n1MhckZ5d7", milHospitalBranch8, office5);

			Visit visit1 = new Visit(patient1, doctor1, new Date());
			Visit visit2 = new Visit(patient2, doctor2, new Date());
			Visit visit3 = new Visit(patient3, doctor3, new Date());
			Visit visit4 = new Visit(patient4, doctor4, new Date());
			Visit visit5 = new Visit(patient5, doctor5, new Date());
			Visit visit6 = new Visit(patient6, doctor6, new Date());
			Visit visit7 = new Visit(patient7, doctor7, new Date());
			Visit visit8 = new Visit(patient8, doctor8, new Date());
			Visit visit9 = new Visit(patient9, doctor9, new Date());
			Visit visit10 = new Visit(patient10, doctor10, new Date());

			hospitalService.addHospital(blankHospital);
			hospitalService.addHospital(milHospital);
			hospitalService.addHospital(hos1);
			hospitalService.addHospital(hos2);
			hospitalService.addHospital(hos3);
			hospitalService.addHospital(hos4);

			officeService.addOffice(officeBlank);
			officeService.addOffice(office1);
			officeService.addOffice(office2);
			officeService.addOffice(office3);
			officeService.addOffice(office4);
			officeService.addOffice(office5);

			branchService.addBranch(blankBranch);
			branchService.addBranch(milHospitalBranch1);
			branchService.addBranch(milHospitalBranch2);
			branchService.addBranch(milHospitalBranch3);
			branchService.addBranch(milHospitalBranch4);
			branchService.addBranch(milHospitalBranch5);
			branchService.addBranch(milHospitalBranch6);
			branchService.addBranch(milHospitalBranch7);
			branchService.addBranch(milHospitalBranch8);
			branchService.addBranch(milHospitalBranch9);
			branchService.addBranch(milHospitalBranch10);

			doctorService.addDoctor(doctor1);
			doctorService.addDoctor(doctor2);
			doctorService.addDoctor(doctor3);
			doctorService.addDoctor(doctor4);
			doctorService.addDoctor(doctor5);
			doctorService.addDoctor(doctor6);
			doctorService.addDoctor(doctor7);
			doctorService.addDoctor(doctor8);
			doctorService.addDoctor(doctor9);
			doctorService.addDoctor(doctor10);

			patientService.addPatient(patient1);
			patientService.addPatient(patient2);
			patientService.addPatient(patient3);
			patientService.addPatient(patient4);
			patientService.addPatient(patient5);
			patientService.addPatient(patient6);
			patientService.addPatient(patient7);
			patientService.addPatient(patient8);
			patientService.addPatient(patient9);
			patientService.addPatient(patient10);

			visitService.addVisit(visit1);
			visitService.addVisit(visit2);
			visitService.addVisit(visit3);
			visitService.addVisit(visit4);
			visitService.addVisit(visit5);
			visitService.addVisit(visit6);
			visitService.addVisit(visit7);
			visitService.addVisit(visit8);
			visitService.addVisit(visit9);
			visitService.addVisit(visit10);

		};
	}
}
