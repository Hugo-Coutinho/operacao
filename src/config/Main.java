package config;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import persistence.Mock;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure("config/mysql_hibernate.cfg.xml");
		new SchemaExport(cfg).create(true, true);
		System.out.println("Tabelas Geradas com Sucesso !!!");
		try {
			new Mock().gerarMock();
			System.out.println("Mock gerado com sucesso !!");
		} catch (Exception e) {
			System.out.println("deu erro ao gerar mock " + e.getMessage());
		}
	}
}
