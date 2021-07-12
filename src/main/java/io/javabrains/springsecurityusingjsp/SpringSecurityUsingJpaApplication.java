package io.javabrains.springsecurityusingjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.javabrains.springsecurityusingjsp.repository.UserDetailsRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserDetailsRepository.class)
public class SpringSecurityUsingJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityUsingJpaApplication.class, args);
	}

}
