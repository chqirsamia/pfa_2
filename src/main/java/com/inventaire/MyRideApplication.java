package com.inventaire;

import com.inventaire.dao.CategorieDAO;
import com.inventaire.dao.EmplacementDAO;
import com.inventaire.dao.ProduitDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})*/
@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = {CategorieDAO.class, EmplacementDAO.class, ProduitDAO.class,UserRepository.class})
public class MyRideApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRideApplication.class, args);
	}

}
