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
import com.inventaire.model.ProduitsNonCommandes;
import com.inventaire.service.ProduitsNonCommandesService;
import com.inventaire.User;
import org.springframework.web.bind.annotation.PostMapping;


//import net.bytebuddy.matcher.ModifierMatcher.Mode;
@Controller
public class AppController {
	@Autowired
    private UserRepository repo;
	@Autowired
	private CustomUserDetailsService  UserService ;
	@Autowired
	private ProduitsNonCommandesService  pncsevice;


	@GetMapping("")
	public String viewHomePage(){
		return "index";
	}
	@GetMapping("/acceuil_admin/{id}")
	public String viewAdminHomePage(Model model,@PathVariable("id") Long id){
		model.addAttribute("id",id);
		return "acceuilA";
	}
	
	@GetMapping("/acceuil_client/{id}")
	public String viewClientHomePage(Model model,@PathVariable("id") Long id){
		model.addAttribute("id",id);

		return "acceuilC";
	}
	@GetMapping("/acceuil_collecteur/{id}")
	public String viewCollecteurHomePage(Model model,@PathVariable("id") Long id){
		model.addAttribute("id",id);
		return "acceuilCO";
	}
	@GetMapping("/acceuil_employeur/{id}")
	public String viewEmployeurHomePage(Model model,@PathVariable("id") Long id){
		model.addAttribute("id",id);
		return "acceuilE";
	}
	@GetMapping("/acceuil_verificateur/{id}")
	public String viewVerificateurHomePage(Model model,@PathVariable("id") Long id){
		model.addAttribute("id",id);
		return "acceuilV";
	}
	
	@GetMapping("/produit")
	public String viewproduitnc(){
		return "produits";
	}
	@GetMapping("/produits/{id}")
	public String viewproduitc(Model model,@PathVariable("id") Long id){
		model.addAttribute("id",id);
		pncsevice.initProduitsNonCommandes(id);
		return "produit_interface_client";
	}
	@GetMapping("/user-list/{id}")
	public String showAdmin(Model model,@PathVariable("id") Long id) {		
		model.addAttribute("list", UserService.getPersonnel());
		model.addAttribute("id",id);
		return "user-list";
	}
	@GetMapping("/user-list/newPersonnel")
	public String newPersonnel(Model model) {
		model.addAttribute("user",new User());
	
		return "user-form";
	}
	@PostMapping(path="/user-list/insertPersonnel")
	public String insertNewPersonnel(@Valid User user, BindingResult result,Model model)
	{UserService.addNewPersonnel(user);
	user.setPasswordncry(user.getPassword());
	BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	String encodedPassword=encoder.encode(user.getPassword());
	user.setPassword(encodedPassword);
	model.addAttribute("list", UserService.getPersonnel());
	
	return "user-list";}
	
	@GetMapping (path="/editPersonnel/{ID}")
	public String editAdmin(@PathVariable Long ID,Model model) {
		User personnel=UserService.getUser(ID);
		
		model.addAttribute("user",personnel);
		return "user-edit";
	}
	
	@PostMapping (path="/Personnel/update/{id}")
	public String updateUser (@PathVariable Long id,@RequestParam(required=false) String tel,
			@RequestParam(required=false) String email,@RequestParam(required=false) String passwordncry,@RequestParam(required=false) String role) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String retourn;
		String encodedPassword=encoder.encode(passwordncry);
		UserService.updatePersonnel(email,tel,id,passwordncry,encodedPassword,role);
		if(role==null)
			retourn= "acceuilC";
		else {
		if (role.equals("A"))
		retourn= "redirect:/user-list/{id}";
		if (role.equals("E"))
			retourn= "acceuilC";
		if (role.equals("CO"))
			retourn= "acceuilCO";
		else 
			retourn= "acceuilV";
		}
		return retourn;
		}
	
	@GetMapping(path="/Personnel/delete/{id}")
	public String deleteAdmin(@PathVariable("id") Long id,Model model) {
		UserService.deleteUser(id);
		model.addAttribute("list", UserService.getPersonnel());
		
		return "user-list";}
	
	
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

	
	@GetMapping("/admin/profil/{id}")
	public String showProfil(Model model,@PathVariable("id") Long id) {
		model.addAttribute("id",id);
		User personnel=UserService.getUser(id);
		
		model.addAttribute("user",personnel);
		return "profile-edit";
	}
	@GetMapping("/employeur/profil/{id}")
	public String showProfile(Model model,@PathVariable("id") Long id) {
		model.addAttribute("id",id);
		User personnel=UserService.getUser(id);
		
		model.addAttribute("user",personnel);
		return "profile-edit";
	}
	@GetMapping("/collecteur/profil/{id}")
	public String showProfilco(Model model,@PathVariable("id") Long id) {
		model.addAttribute("id",id);
		User personnel=UserService.getUser(id);
		
		model.addAttribute("user",personnel);
		return "profile-edit";
	}
	@GetMapping("/verificateur/profil/{id}")
	public String showProfilv(Model model,@PathVariable("id") Long id) {
		model.addAttribute("id",id);
		User personnel=UserService.getUser(id);
		
		model.addAttribute("user",personnel);
		return "profile-edit";
	}
	@GetMapping("/client/profil/{id}")
	public String showProfilc(Model model,@PathVariable("id") Long id) {
   
		User personnel=UserService.getUser(id);
		model.addAttribute("id",id);
		model.addAttribute("user",personnel);
		return "profile-edit";
	}
	
	@PostMapping("/process_signup")
	public String processSignUp(User user) {
		User existing = repo.findByEmail(user.getEmail());
        if (existing != null){
            return "redirect:/inscription?error";
        }
     
        else {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		user.setPasswordncry(user.getPassword());
		String encodedPassword=encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "redirect:/connexion?success";
        }
	}

	}

	

