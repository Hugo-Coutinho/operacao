package ctrlPattern;

import java.util.List;

import entity.Anotacao;
import entity.Endereco;
import entity.Perfil;
import type.TypePermissao;
import type.TypeSexo;

public interface IUsuarioModel {

	public String getFoto();

	public Integer getSenha();

	public TypePermissao getPermissao();

	public TypeSexo getSexo();

	public Integer getIdUsuario();

	public String getEmail();

	public String getNome();

	public Endereco getEndereco();

	public Perfil getPerfil();

	public List<Anotacao> getAnotacoes(); 

}
