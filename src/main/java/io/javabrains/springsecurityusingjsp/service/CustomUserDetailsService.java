package io.javabrains.springsecurityusingjsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrains.springsecurityusingjsp.entity.CustomeUserDetails;
import io.javabrains.springsecurityusingjsp.entity.UserDetailsEntity;
import io.javabrains.springsecurityusingjsp.repository.UserDetailsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetailsEntity customerDetails = userDetailsRepository.findByUsername(username).orElse(null);

		if (customerDetails == null) {

			throw new UsernameNotFoundException("User does not exits in our Records ..!!");
		}

		return new CustomeUserDetails(customerDetails.getUsername().trim(), customerDetails.getPassword().trim(),true,
				customerDetails.isActive(), customerDetails.getAuthority().trim());
	}

}
