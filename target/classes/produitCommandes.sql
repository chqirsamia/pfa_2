drop table produits_commandes;
CREATE TABLE IF NOT EXISTS produit_commandes(
        id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
        id_produit int,
        Quantite_commande int,
        id_user int ,
        CONSTRAINT FK_PC foreign key (id_produit) references Produit(id_produit),
        CONSTRAINT FK_PC2 foreign key (id_user) references users(id)

);
INSERT INTO produit_commandes VALUES (1,1,20,4);
INSERT INTO produit_commandes VALUES (null,5,45,4);
select * from produit_commandes;