package config;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure("config/mysql_hibernate.cfg.xml");
		new SchemaExport(cfg).create(true, true);
		System.out.println("Tabelas Geradas com Sucesso !!!");
	}
}


//alter table Endereco 
//drop 
//foreign key FK_55kw5rceticbj76wi4u8kaooy
//
//drop table if exists Endereco
//
//drop table if exists usuario
//
//create table Endereco (
//idEndereco integer not null auto_increment,
//bairro varchar(255),
//cep varchar(255),
//cidade varchar(255),
//estado varchar(255),
//logradouro varchar(60),
//id_usuario integer,
//primary key (idEndereco)
//)
//
//create table usuario (
//idUsuario integer not null auto_increment,
//email varchar(50),
//nome varchar(50),
//permissao  enum ('USUARIO','ADMINISTRADOR'),
//senha varchar(50),
//sexo  enum ('M','F'),
//primary key (idUsuario)
//)
//
//alter table Endereco 
//add constraint FK_55kw5rceticbj76wi4u8kaooy 
//foreign key (id_usuario) 
//references usuario (idUsuario)
//Tabelas Geradas com Sucesso !!!
