package ipz.healthservice;

import ipz.healthservice.models.Hospital;
import ipz.healthservice.repositories.IHospitalRepository;
import ipz.healthservice.services.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class HealthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(HospitalService hospitalService) {
		return (args) -> {
//			hospitalService.addHospital(new Hospital("109 Military Hospital SPZOZ", "Ksiedza Piotra Skargi 9/11, 71-422 Szczecin", "Military"));
//			hospitalService.addHospital(new Hospital("Samodzielny Publiczny Szpital Kliniczny Nr 1 Pomorskiego Uniwersytetu Medycznego im. prof. Tadeusza Sokołowskiego", "Unii Lubelskiej 1, 71-252 Szczecin", "Public"));
//			hospitalService.addHospital(new Hospital("SSP ZOZ MSWiA w Szczecinie", "Jagiellońska 44, 70-382 Szczecin", "Public"));
//			hospitalService.addHospital(new Hospital("Szpital Miejski Im. Sw. Karola Boromeusza", "aleja Wyzwolenia 52, 71-506 Szczecin", "Rehab"));
			hospitalService.addHospital(new Hospital("name1", "addr1", "Military"));
			hospitalService.addHospital(new Hospital("name2", "addr2", "Public"));
			hospitalService.addHospital(new Hospital("name3", "addr3", "Public"));
			hospitalService.addHospital(new Hospital("name4", "addr4", "Rehab"));
		};
	}
}
