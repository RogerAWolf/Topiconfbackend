package nl.topicus.topiconfbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })

public class TopiconfbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopiconfbackendApplication.class, args);
	}

}