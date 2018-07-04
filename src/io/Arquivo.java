package io;

import java.io.FileWriter;

public class Arquivo implements IArquivo {

	FileWriter fw;
	String caminho;

	public Arquivo(String p) {
		this.caminho = p;
	}

	@Override
	public void open() throws Exception {
		fw = new FileWriter(caminho, false);
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
}
