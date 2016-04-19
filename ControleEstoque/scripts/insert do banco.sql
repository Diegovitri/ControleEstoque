use controleestoque;

select * from tb_construtora;

insert into tb_construtora(nm_construtora) 
values('C & A Construtora');

select * from tb_obra;
insert into tb_obra(nm_obra,ds_endereco,numero,cd_construtora,res_obra)
values('Corrego do Oleo','Rua do Oleo - Mansour',130,1,'Pedro'),
('Residencial Maravilha','Rua da Maravilha - Maravilha',600,1,'João');
delete from tb_obra where cd_obra in (3,4);

select * from almoxarifado;

insert into almoxarifado(resp_almoxarifado,cd_obra) values('Pedro',1),('João',2);


select * from tb_material;

insert into tb_material(nm_material,qt_estoque)
values('Cimento',10),('Cal',10),('Tijolo',50000),
('Telha',10000),('Tinta',1500),('Massa Acrilica',100),
('Cano',100),('Luva',100),('Prego',1000),
('Veda Rosca',158),('Lixa',300),('Rolo',100);

select * from alocacao_de_material;

insert into alocacao_de_material(cd_obra,cd_material,qtd_solicitada,dt_solicitacao,nm_solicitante)
values(1,1,5,'2016-04-08','Roberto'),(1,2,5,'2016-04-08','Roberto'),(1,3,550,'2016-04-08','Roberto'),
(1,4,1000,'2016-04-08','Roberto'),(1,5,50,'2016-04-08','Roberto'),(1,6,30,'2016-04-08','Roberto'),
(2,7,1,'2016-04-08','Roberto'),(2,8,3,'2016-04-08','Roberto'),(2,9,50,'2016-04-08','Roberto');


select * from alocacao_de_material;
select * from tb_material;
select * from tb_construtora;
select * from almoxarifado;
select * from tb_obra;

delete from alocacao_de_material where cd_almoxarifado = 1;
drop database controleestoque;