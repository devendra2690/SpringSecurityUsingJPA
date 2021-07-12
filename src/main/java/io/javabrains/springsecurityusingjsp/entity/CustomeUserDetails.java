package io.javabrains.springsecurityusingjsp.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomeUserDetails implements UserDetails {

	private String username;
	private String password;
	private boolean accountNotExpired;
	private boolean enabled;
	private Collection<GrantedAuthority> authorities;

	public CustomeUserDetails(String username, String password, boolean accountNotExpired, boolean enabled,
			String authorities) {
		this.username = username;
		this.password = password;
		this.accountNotExpired = accountNotExpired;
		this.enabled = enabled;
		this.authorities = Arrays.stream(authorities.split(",")).map(SimpleGrantedAuthority:: new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.authorities;
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return this.accountNotExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return this.enabled;
	}

}
