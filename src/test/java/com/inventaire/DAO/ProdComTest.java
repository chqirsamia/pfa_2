package com.inventaire.DAO;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import com.inventaire.model.*;
import com.inventaire.dao.*;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProdComTest {
	@Autowired
	private ProdComDAO prodcomdao;
	@Autowired
private TestEntityManager entityManager;
	@Test
	
	public void testAddProdCom()
	{
		Commande commande=entityManager.find(Commande.class, 1);
		Produit product=entityManager.find(Produit.class, 1);
		ProdCom prod=new ProdCom();
		prod.setCommande(commande);
		prod.setProduct(product);
		prod.setPrix(product.getPrix_unitaire());
		prod.setQuantite(5);
		prod.setTotal(product.getPrix_unitaire()*5);
		ProdCom prodsave=prodcomdao.save(prod);
		assertTrue(prodsave.getId()>0);
		
	}
}

