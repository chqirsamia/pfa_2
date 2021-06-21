drop table command;
CREATE TABLE IF NOT EXISTS command(
      id_commande int PRIMARY KEY NOT NULL AUTO_INCREMENT,
      totale float,
      date_commande date,
      id_user int ,
      CONSTRAINT FK_C2 foreign key (id_user) references users(id)

);
/*INSERT INTO commande VALUES (1,1,20,4);
INSERT INTO commande VALUES (null,5,45,4);
select * from commande;*/