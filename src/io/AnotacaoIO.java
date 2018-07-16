package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnotacaoIO implements IArquivo {

	FileWriter fw;
	String nome;
	final String caminho = System.getProperty("user.dir");

	public AnotacaoIO(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}
	
	public AnotacaoIO() {
		// TODO Auto-generated constructor stub
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

	public String lerArquivo(String nome) {

		try {

			FileReader fr = new FileReader(caminho + "\\" + nome + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = br.readLine();
			String resp = "";
			while (linha != null) {
				resp += linha + "\n";
				linha = br.readLine();
			}
			br.close();
			return resp;

		} catch (Exception e) {
			// TODO: handle exception
			return "não encontrado";
		}
	}

	public static void main(String[] args) {
		try {
			AnotacaoIO noteIo = new AnotacaoIO("diaTeste");
			noteIo.open();
			noteIo.writeFile("teste o dia todo ...\n vai vendo.");
			noteIo.close();
			System.out.println(noteIo.lerArquivo("diaTeste"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
