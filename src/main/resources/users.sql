CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment primary key,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL unique,
  `sexe` varchar(10) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into users(nom,prenom,email,sexe,tel,password,role,passwordncry)values ("chqir","samia","samia@gmail.com","F","0666666666","$2a$10$bdnWqNxp.vFFETHHNpxLUuosYxgYVd0hLBo.wFdFWtqsMdUKnBpam","A","samia");
insert into users(nom,prenom,email,sexe,tel,password,role,passwordncry)values ("ajabri","hiba","hiba@gmail.com","F","0666666666","$2a$10$bdnWqNxp.vFFETHHNpxLUuosYxgYVd0hLBo.wFdFWtqsMdUKnBpam","CO","samia");
insert into users(nom,prenom,email,sexe,tel,password,role,passwordncry)values ("ajabri","hiba","hibav@gmail.com","F","0666666666","$2a$10$bdnWqNxp.vFFETHHNpxLUuosYxgYVd0hLBo.wFdFWtqsMdUKnBpam","V","samia");
insert into users(nom,prenom,email,sexe,tel,password,role,passwordncry)values ("ajabri","hiba","hibac@gmail.com","F","0666666666","$2a$10$bdnWqNxp.vFFETHHNpxLUuosYxgYVd0hLBo.wFdFWtqsMdUKnBpam","C","samia");
insert into users(nom,prenom,email,sexe,tel,password,role,passwordncry)values ("chqir","samia","samiae@gmail.com","F","0666666666","$2a$10$bdnWqNxp.vFFETHHNpxLUuosYxgYVd0hLBo.wFdFWtqsMdUKnBpam","E","samia");
