package br.com.example.davidarchanjo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "br.com.example.davidarchanjo")
@SpringBootApplication(scanBasePackages = "br.com.example.davidarchanjo")
@EnableJpaRepositories(basePackages = "br.com.example.davidarchanjo")
public class JpaAuditingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAuditingApplication.class, args);
	}
}
