package ctrlPattern;

import entity.Endereco;

public interface IUsuarioModel {

	public String getFoto();

	public Integer getSenha();

	public String getPermissao();

	public String getSexo();

	public Integer getIdUsuario();

	public String getEmail();
	
	public String getNome();
	
	public Endereco getEndereco();

}
