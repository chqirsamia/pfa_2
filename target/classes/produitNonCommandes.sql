drop table produits_non_commandes;
CREATE TABLE IF NOT EXISTS produits_non_commandes(
                                                 id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                                 id_produit int,
                                                 CONSTRAINT FK_PNC foreign key (id_produit) references Produit(id_produit)

);
INSERT INTO produits_non_commandes VALUES (1,8);
INSERT INTO produits_non_commandes VALUES (null,9);
select * from produits_non_commandes;