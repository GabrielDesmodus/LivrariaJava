create database bookshop;

use bookshop;

create table livros (
id_livros int primary key AUTO_INCREMENT,
nome varchar(20) NOT NULL,
ano int,
autor varchar(50),
tipo varchar(20),
genero varchar(20),
preço decimal(10,2) NOT NULL
);

create table comprador(
id_comprador int primary key AUTO_INCREMENT,
nome varchar(20)  NOT NULL,
cpf varchar(14) NOT NULL
);

create table compra (
id_compra int primary key AUTO_INCREMENT, 
id_livros int NOT NULL,
id_comprador int NOT NULL,
qtd int NOT NULL,
data datetime NOT NULL,
CONSTRAINT fk_id_livros FOREIGN KEY (id_livros) REFERENCES livros (id_livros),
CONSTRAINT fk_id_comprador FOREIGN KEY (id_comprador) REFERENCES comprador (id_comprador)
);

-- dados iniciais

insert into livros values(1, 'Minha Breve História',2013,'Stephen Hawking','Livro','Biografia','20,00'); 
insert into livros values(2, 'O Monstro do Pântano',1971,'Alex Olsen','HQ','Terror','5,00'); 
insert into livros values(3, 'Ghost in The Shell',1991,'Masamune Shirow','Mangá','Ação','10,00');

insert into comprador values(1,'John','506.974.799-05');
insert into comprador values(2,'Maria','596.074.669-09');
insert into comprador values(3,'Kahua','666.395.975-07');

insert into compra(id_livros,id_comprador,qtd,data) values(1,2,2,CURDATE());
insert into compra(id_livros,id_comprador,qtd,data) values(2,1,3,CURDATE());
insert into compra(id_livros,id_comprador,qtd,data) values(3,3,3,CURDATE());
