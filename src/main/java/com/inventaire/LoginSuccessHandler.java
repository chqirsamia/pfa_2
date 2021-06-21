package com.inventaire;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private UserRepository repo;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
         
        String redirectURL = request.getContextPath();
        Long id=repo.findByEmail(userDetails.getUsername()).getId();
        if (userDetails.hasRole("A")) {
        	
            redirectURL = "acceuil_admin/"+id;
        } else if (userDetails.hasRole("C")) {
            redirectURL = "acceuil_client/"+id;
        } else if (userDetails.hasRole("CO")) {
            redirectURL = "acceuil_collecteur/"+id;
        } 
        else if (userDetails.hasRole("E")) {
            redirectURL = "acceuil_employeur/"+id;
        } 
        else if (userDetails.hasRole("V")) {
            redirectURL = "acceuil_verificateur/"+id;
        } 
         
        response.sendRedirect(redirectURL);
         
    }
 
}
