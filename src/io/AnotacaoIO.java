package io;

import java.io.FileWriter;

public class AnotacaoIO implements IArquivo {

	FileWriter fw;
	String nome;
	final String caminho = System.getProperty("user.dir");

	public AnotacaoIO(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	@Override
	public void open() throws Exception {
		// TODO Auto-generated method stub
		fw = new FileWriter(caminho + "\\" + nome + ".txt", false);
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		fw.close();
	}

	@Override
	public void writeFile(String t) throws Exception {
		// TODO Auto-generated method stub
		fw.write(t);
		fw.flush();
	}
}
