package co.com.nubicall.users.main;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "co.com.nubicall.users.services", "co.com.nubicall.users.controllers",
		"co.com.nubicall.users.config" })
@EntityScan(basePackages = { "co.com.nubicall.users.entities" })
@EnableJpaRepositories(basePackages = { "co.com.nubicall.users.repositories" })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
		Locale.setDefault(Locale.forLanguageTag("es_CO"));

	}

}
