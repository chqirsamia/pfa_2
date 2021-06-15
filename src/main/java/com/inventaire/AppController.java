package com.inventaire;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.inventaire.CustomUserDetailsService;
import com.inventaire.UserRepository;
import com.inventaire.User;
import org.springframework.web.bind.annotation.PostMapping;


//import net.bytebuddy.matcher.ModifierMatcher.Mode;
@Controller
public class AppController {
	@Autowired
    private UserRepository repo;
	@Autowired
	private CustomUserDetailsService  UserService ;


	@GetMapping("")
	public String viewHomePage(){
		return "index";
	}
	@GetMapping("/acceuil_admin")
	public String viewAdminHomePage(){
		return "acceuilA";
	}
	@GetMapping("/acceuil_client")
	public String viewClientHomePage(){
		return "acceuilC";
	}
	@GetMapping("/acceuil_collecteur")
	public String viewCollecteurHomePage(){
		return "acceuilCO";
	}
	@GetMapping("/connexion")
	public String showSignInForm(Model model) {
		model.addAttribute("user",new User());
		return "signin";
	}
	@GetMapping("/inscription")
	public String showSignUpForm(Model model) {
		model.addAttribute("user",new User());
		return "signup";
	}

	@GetMapping("/acceuilA")
	public String showHome() {
		return "acceuilA";
	}
	
	
	@PostMapping("/process_signup")
	public String processSignUp(User user) {
		User existing = repo.findByEmail(user.getEmail());
        if (existing != null){
            return "redirect:/inscription?error";
        }
        else {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encodedPassword=encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "redirect:/connexion?success";
        }
	}

	}

	

