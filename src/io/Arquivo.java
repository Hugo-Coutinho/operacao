package io;

import java.io.FileWriter;

public class Arquivo implements IArquivo {

	FileWriter fw;
	
	@Override
	public void open() throws Exception {
		fw = new FileWriter("E:\\Usuários\\Administrador Local\\Documents\\documentoWord.txt",false);
	}

	@Override
	public void close() throws Exception {
		fw.close();

	}

	@Override
	public void writeFile(String t) throws Exception {
		fw.write(t);
		fw.flush();

	}

	public static void main(String[] args) {

		Arquivo a = new Arquivo();
		try {
			a.open();
			a.writeFile("primeiro projeto, ta um trabalho do krlho e ta dando tudo errado):");
			a.close();
			System.out.println("gravado com sucesso!!");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
