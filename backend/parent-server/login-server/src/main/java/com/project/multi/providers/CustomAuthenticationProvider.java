package com.project.multi.providers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.multi.entities.Users;
import com.project.multi.repository.UsersRepository;



@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
    public Authentication authenticate(Authentication auth) 
      throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials()
            .toString();
        Users user = usersRepository.findByUserName(username);
        if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken
              (username, password, Collections.emptyList());
        } else {
            throw new
              BadCredentialsException("El usuario/contraseña introducidos no son correctos");
        }
    }
 
    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
