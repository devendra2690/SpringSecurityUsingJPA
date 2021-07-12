package io.javabrains.springsecurityusingjsp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.javabrains.springsecurityusingjsp.entity.UserDetailsEntity;
import io.javabrains.springsecurityusingjsp.repository.UserDetailsRepository;

@Component
public class PreloadData implements CommandLineRunner{

	@Autowired
	UserDetailsRepository userDetailsRepository; 
	
	@Autowired
	PasswordEncoder passEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		userDetailsRepository.deleteAll();
		
		UserDetailsEntity detailsEntity = new UserDetailsEntity();
		detailsEntity.setUsername("user");
		//detailsEntity.setPassword(passEncoder.encode("user"));
		detailsEntity.setPassword(passEncoder.encode("user"));
		detailsEntity.setAuthority("USER");
		detailsEntity.setActive(true);
		
		userDetailsRepository.save(detailsEntity);
	}

}
