use controleestoque;

insert into almoxarifado(resp_almoxarifado) values('Pedro'),('João');

insert into tb_obra(nm_obra,ds_endereco,numero,cd_almoxarifado)
values('Corrego do Oleo','Rua do Oleo - Mansour',130,1),
('Residencial Maravilha','Rua da Maravilha - Maravilha',600,2);

insert into tb_construtora(nm_contrutora,cd_obra) 
values('C & A Construtora',1);

insert into tb_material(nm_material,qt_estoque)
values('Cimento',10),('Cal',10),('Tijolo',50000),
('Telha',10000),('Tinta',1500),('Massa Acrilica',100),
('Cano',100),('Luva',100),('Prego',1000),
('Veda Rosca',158),('Lixa',300),('Rolo',100);

insert into alocacao_de_material(cd_almoxarifado,cd_material,qtd_solicitada,dt_solicitacao,nm_solicitante)
values(1,1,5,2016-04-07,'Roberto'),(1,2,5,2016-04-07,'Roberto'),(1,3,550,2016-04-07,'Roberto'),
(1,4,1000,2016-04-07,'Roberto'),(1,5,50,2016-04-07,'Roberto'),(1,6,30,2016-04-07,'Roberto'),
(1,7,1,2016-04-07,'Roberto'),(1,8,3,2016-04-07,'Roberto'),(1,9,50,2016-04-07,'Roberto');


insert into alocacao_de_material(cd_almoxarifado,cd_material,qtd_solicitada,dt_solicitacao,nm_solicitante)
values(1,1,9,date_format(07/2016, '%m %y'),'Roberto');

select * from alocacao_de_material;
select * from tb_material;

delete from alocacao_de_material where cd_almoxarifado = 1;
drop database controleestoque;