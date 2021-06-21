drop table commande_produit;
CREATE TABLE IF NOT EXISTS commande_produit(
      id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
      id_commande int,
      id_produit int,
      Quantite_commande int,
      CONSTRAINT FK_PpC foreign key (id_produit) references Produit(id_produit)
);