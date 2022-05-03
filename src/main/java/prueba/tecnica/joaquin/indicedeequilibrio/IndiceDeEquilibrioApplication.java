package prueba.tecnica.joaquin.indicedeequilibrio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@ComponentScan("prueba.tecnica.joaquin.indicedeequilibrio")
public class IndiceDeEquilibrioApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndiceDeEquilibrioApplication.class, args);
	}

}
