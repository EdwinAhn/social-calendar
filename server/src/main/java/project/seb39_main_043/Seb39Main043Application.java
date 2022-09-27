package project.seb39_main_043;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import project.seb39_main_043.member.entity.Member;

@EnableJpaAuditing
@SpringBootApplication
public class Seb39Main043Application {

	public static void main(String[] args) {
		SpringApplication.run(Seb39Main043Application.class, args);

	}



}
