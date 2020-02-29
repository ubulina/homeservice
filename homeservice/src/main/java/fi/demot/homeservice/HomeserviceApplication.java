package fi.demot.homeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.demot.homeservice.domain.Henkilo;
import fi.demot.homeservice.domain.HenkiloRepository;
import fi.demot.homeservice.domain.Tehtava;
import fi.demot.homeservice.domain.TehtavaRepository;

@SpringBootApplication
public class HomeserviceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HomeserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HomeserviceApplication.class, args);
			
	}
	
	@Bean
	public CommandLineRunner demo(HenkiloRepository repository, TehtavaRepository tehtavarepository) {

		// syötetään H2:een materiaalia
		return (args) -> {
			
			log.info("talletetaan tehtavia H2-tietokantaan");
			
			tehtavarepository.save(new Tehtava("siivous"));
			tehtavarepository.save(new Tehtava("ikkunanpesu"));
			tehtavarepository.save(new Tehtava("lastenhoito"));
			tehtavarepository.save(new Tehtava("lemmikinhoito"));
			tehtavarepository.save(new Tehtava("ruuanlaitto"));
			tehtavarepository.save(new Tehtava("digiapu"));
			tehtavarepository.save(new Tehtava("auton korjaus"));
			tehtavarepository.save(new Tehtava("vaatteiden korjaus"));
			tehtavarepository.save(new Tehtava("kodin korjaustyöt"));
			
			log.info("talletetaan joukko tyontekijoita");
			
			repository.save(new Henkilo("Matti", "Mikkonen", "040567899", "matti@mikkonen.fi", 1956, 15, tehtavarepository.findByName("auton korjaus").get(0)));
			repository.save(new Henkilo("Maija", "Virtanen", "050123456", "maija@virtanen.fi", 1949, 16, tehtavarepository.findByName("digiapu").get(0)));
			repository.save(new Henkilo("Urmas", "Johansson", "040123489", "urmas@johansson.fi", 1972, 10, tehtavarepository.findByName("lemmikinhoito").get(0)));

			log.info("fetch all henkilot");
			for (Henkilo henkilo : repository.findAll()) {
				log.info(henkilo.toString());

			}

			log.info("fetch all tehtavat");
			for (Tehtava tehtava : tehtavarepository.findAll()) {
				log.info(tehtava.getName());
			}
			
			
		};
		
	}

}
