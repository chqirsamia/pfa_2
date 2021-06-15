drop table Emplacement;
CREATE TABLE IF NOT EXISTS Emplacement(
            id_emplacement int PRIMARY KEY NOT NULL AUTO_INCREMENT,
            nom_emplacement varchar(30)
);
INSERT INTO Emplacement VALUES (1,'Dipôt A');
INSERT INTO Emplacement VALUES (null,'Dipôt B');
INSERT INTO Emplacement VALUES (null,'Dipôt C');
INSERT INTO Emplacement VALUES (null,'Dipôt D');
select * from Emplacement;