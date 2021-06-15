drop table Produit;
CREATE TABLE IF NOT EXISTS Produit(
    id_produit int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_categorie int ,
    id_emplacement int,
    id_employee int,
    code int,
    nom_produit varchar(30),
    titre varchar(300) DEFAULT NULL,
    description varchar(300) DEFAULT NULL,
    image longblob,
    prix_unitaire float,
    quantite int,
    etat_stock varchar(30),
    date_cree date,
    date_modifier date,
    date_suppr date,
    CONSTRAINT FK_CAT foreign key (id_categorie) references Categorie(id_categorie),
    CONSTRAINT FK_EMPLAC foreign key (id_emplacement) references Emplacement(id_emplacement),
    CONSTRAINT FK_EMP foreign key (id_employee) references Employee(id_employee)
    );
INSERT INTO Produit VALUES (1,1,1,1,04511475,'ATC','Anatomo-Therapeutical-Chemical','description_ATC',null,45.1,1000,'Article en stock','2009-06-12',null,null);
INSERT INTO Produit VALUES (null,1,1,1,04511475,'BAN','British Approved Name','description_ATC',null,97.12,900,'Article en stock','2010-02-12',null,null);
INSERT INTO Produit VALUES (null,1,1,1,04511475,'BNF','British National Formulary','description_ATC',null,108.2,520,'Article en stock','2001-05-12',null,null);
INSERT INTO Produit VALUES (null,2,1,1,04511475,'BPHS','Basic Package of Health Services for Afghanistan','description_ATC',null,98.12,980,'Article en stock','2009-05-12',null,null);
INSERT INTO Produit VALUES (null,2,1,1,04511475,'DG','Director General','description_ATC',null,18.12,800,'Article en stock','2009-06-12',null,null);
INSERT INTO Produit VALUES (null,3,2,1,04511475,'EDL','Essential Drugs List of Afghanistan','description_ATC',null,50.34,80,'Article en stock','2009-07-12',null,null);
INSERT INTO Produit VALUES (null,4,2,1,04511475,'EMRO','Eastern Mediterranean Regional Office (WHO)','description_ATC',null,60.12,770,'Article en stock','2010-08-12',null,null);
INSERT INTO Produit VALUES (null,4,2,1,04511475,'EPhMRA','European Pharmaceutical Market Research Association','description_ATC',null,98.12,800,'Article en stock','2001-06-12',null,null);
INSERT INTO Produit VALUES (null,5,4,1,04511475,'EPHS','Essential Package of Hospital Services for Afghanistan','description_ATC',null,95.12,800,'Article en stock','2001-07-12',null,null);
INSERT INTO Produit VALUES (null,6,4,1,04511475,'GD','General Directorate','description_ATC',null,200.00,800,'Article en stock','2001-06-12',null,null);
select * from Produit;


/* Find produit par categorie */
select * from Produit p where p.id_categorie in (select c.id_categorie from Categorie c where c.nom_categorie like '%bio%');
/* Find produit par mot_cle */
select p.nom_produit,p.titre,p.description from Produit p where p.nom_produit like '%ATC%' or p.titre like '%ATC%' or p.description like '%ATC%';
/* Find produit par annee de creation */
select * from Produit p where DATE_FORMAT ( p.date_cree, '%Y')= 2009;
select * from Produit p where DATE_FORMAT ( p.date_cree, '%m')= 6;
select * from Produit p order by p.date_cree desc;

SELECT * FROM produit LIMIT 2;