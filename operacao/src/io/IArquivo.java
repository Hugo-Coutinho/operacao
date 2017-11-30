package io;

public interface IArquivo {

	
	public void open()throws Exception;
	public void close()throws Exception;
	public void writeFile(String t)throws Exception;
	
}
