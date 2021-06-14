drop table Categorie;
CREATE TABLE IF NOT EXISTS Categorie(
            id_categorie int PRIMARY KEY NOT NULL AUTO_INCREMENT,
            nom_categorie varchar(30),
            description varchar(300),
            image longblob,
            date_cree date,
            date_modifier date DEFAULT NULL,
            date_suppr date DEFAULT NULL
);
INSERT INTO Categorie VALUES (1,'médicament générique','desc_du_medicament_generique',null,'2009-06-12','2019-02-01',null);
INSERT INTO Categorie VALUES (null,'médicament biosimilaire','desc_du_medicament_biosimilaire',null,'2009-06-12',null,null);
INSERT INTO Categorie VALUES (null,'médicament orphelin','desc_du_medicament_orphelin',null,'2009-06-12',null,null);
INSERT INTO Categorie VALUES (null,'médicament biologique','desc_du_medicament_biologique',null,'2009-06-12',null,null);
INSERT INTO Categorie VALUES (null,'médicament à base de plantes','desc_du_medicament_base_de_plantes',null,'2009-06-12',null,null);
INSERT INTO Categorie VALUES (null,'médicament essentiel','desc_du_medicament_essentiel',null,'2009-06-12',null,null);
select * from Categorie;