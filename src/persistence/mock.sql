use system01;

delimiter $
create procedure gerarClienteEndereco()
begin	
insert into perfil values(350,'https://i.ytimg.com/vi/azEatWLF9hI/hqdefault.jpg');
insert into endereco values(123,'gamboa','20221160','Rj','Rj','Rua sacadura cabral 327');
insert into usuario values(1,'michelsolivapqd@gmail.com','https://i.ytimg.com/vi/azEatWLF9hI/hqdefault.jpg','michel','administrador',567,'m',null,123,350);

insert into anotacao values(1,date('2018/07/15'),'hexa');
insert into perfil values(351,'http://media.ufc.tv/fighter_images/Vitor_Belfort/BELFORT_VITOR.png');
insert into endereco values(124,'saude','20221123','Rj','Rj','Rua Livramento 3');
insert into usuario values(2,'hugocoutinho2011@gmail.com','http://media.ufc.tv/fighter_images/Vitor_Belfort/BELFORT_VITOR.png','hugo','administrador',567,'m',1,124,351);

insert into anotacao values(2,date('200/03/15'),'java');
insert into perfil values(352,'https://cdn.lowkickmma.com/wp-content/uploads/2018/01/Jon-Jones.jpg');
insert into endereco values(125,'bonsucesso','21321160','Rj','Rj','Rua Mantem 302');
insert into usuario values(3,'belem@gmail.com','https://cdn.lowkickmma.com/wp-content/uploads/2018/01/Jon-Jones.jpg','belem','administrador',567,'m',2,125,352);

insert into perfil values(353,'https://i.ytimg.com/vi/LjiKKkP77es/hqdefault.jpg');
insert into endereco values(126,'maracana','42221160','Rj','Rj','Maracana 211');
insert into usuario values(4,'vandame@gmail.com','https://i.ytimg.com/vi/LjiKKkP77es/hqdefault.jpg','vandame','administrador',567,'m',null,126,353);

insert into perfil values(354,'http://beta.ems.ladbiblegroup.com/s3/content/808x455/5ca2abf45a8d5db9619d2fabd8dde802.png');
insert into endereco values(127,'estadio','12221160','Rj','Rj','Estadio 21');
insert into usuario values(5,'stalone@gmail.com','http://beta.ems.ladbiblegroup.com/s3/content/808x455/5ca2abf45a8d5db9619d2fabd8dde802.png','stalone','administrador',567,'m',null,127,354);


insert into perfil values(380,'https://imgc.allpostersimages.com/img/print/posters/roger-cruz-magneto-no-1-cover-magneto-flying_a-G-13483435-4988577.jpg');
insert into endereco values(10,'Centro','324928187','mg','mg','Rua da vele 2');
insert into usuario values(6,'magneto@gmail.com','https://imgc.allpostersimages.com/img/print/posters/roger-cruz-magneto-no-1-cover-magneto-flying_a-G-13483435-4988577.jpg','magneto','usuario',567,'m',null,10,380);

insert into perfil values(381,'https://www.ftsa.edu.br/home/images/tempestade.jpg');
insert into endereco values(11,'tempestade','12221160','Rj','Rj','Estadio 21');
insert into usuario values(7,'tempestade@gmail.com','https://www.ftsa.edu.br/home/images/tempestade.jpg','tempestade','usuario',567,'f',null,11,381);

insert into perfil values(382,'https://static3.tcdn.com.br/img/img_prod/460977/boneco_ciclope_cyclops_x_men_the_laser_eye_escala_1_6_toys_era_20293_2_20170516182451.jpg');
insert into endereco values(12,'Muambator','234321600','RN','RN','RUA DA MIRI 2');
insert into usuario values(8,'ciclope@gmail.com','https://static3.tcdn.com.br/img/img_prod/460977/boneco_ciclope_cyclops_x_men_the_laser_eye_escala_1_6_toys_era_20293_2_20170516182451.jpg','ciclope','usuario',567,'m',null,12,382);

insert into perfil values(383,'http://3.bp.blogspot.com/-sFPY0bKQi0s/T2yru3fuPKI/AAAAAAAAFh8/DTDjLX9rrxQ/s640/vampira+maila+nurmi.jpg');
insert into endereco values(13,'vampira','00221160','Rj','Rj','Estadio 21');
insert into usuario values(9,'Vampira@gmail.com','http://3.bp.blogspot.com/-sFPY0bKQi0s/T2yru3fuPKI/AAAAAAAAFh8/DTDjLX9rrxQ/s640/vampira+maila+nurmi.jpg','vampira','usuario',567,'f',null,13,383);

insert into perfil values(384,'https://pbs.twimg.com/profile_images/833767319973212161/Ft904pMk_400x400.jpg');
insert into endereco values(15,'Nova Iguacu','329428711','Rj','Rj','Rua da estrada 2');
insert into usuario values(10,'Goku@gmail.com','https://pbs.twimg.com/profile_images/833767319973212161/Ft904pMk_400x400.jpg','goku','usuario',567,'m',null,15,384);

end
$
delimiter ;
call gerarClienteEndereco();
drop procedure gerarClienteEndereco;




