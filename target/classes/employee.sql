drop table Employee;
CREATE TABLE IF NOT EXISTS Employee(
        id_employee int PRIMARY KEY NOT NULL AUTO_INCREMENT,
        nom_employee varchar(30)
);
INSERT INTO Employee VALUES (1,'AJABRI HIBA');
INSERT INTO Employee VALUES (null,'CHQUIR SAMIA');
select * from Employee;