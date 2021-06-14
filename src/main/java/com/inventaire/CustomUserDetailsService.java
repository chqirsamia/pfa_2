package com.inventaire;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.inventaire.User;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
	
	public void deleteUser(long id) {
		repo.deleteById(id);
		
	}
	
	public List<User> getPersonnel() {
		
		return repo.findPersonnel();
	}

	
	public void addNewPersonnel(User user) {
		User userByID=repo.findByEmail(user.getEmail());
		if (userByID!= null)
			throw new IllegalStateException("email existant");
		
	repo.save(user);
	}

	public User getUser(Long id) {
		return repo.findUserByID(id);
		
	}

	public void updatePersonnel(String email, String tel, Long id, String password,  String pass,String role)
	{
		Optional <User> userByID=repo.findById(id);
		User user=userByID.get();
		user.setEmail(email);
		user.setTel(tel);
		user.setRole(role);
		user.setPassword(pass);
		user.setPasswordncry(password);
		repo.save(user);
	}
	
}
