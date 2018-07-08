package ctrlPattern;

import java.util.List;

import entity.Anotacao;
import entity.Endereco;
import entity.Perfil;

public interface IUsuarioModel {

	public String getFoto();

	public Integer getSenha();

	public String getPermissao();

	public String getSexo();

	public Integer getIdUsuario();

	public String getEmail();

	public String getNome();

	public Endereco getEndereco();

	public Perfil getPerfil();

	public List<Anotacao> getAnotacoes(); 

}
