package ctrlPattern;

import java.util.ArrayList; 
import java.util.List;

import entity.Anotacao;
import entity.Endereco;
import type.TypePermissao;
import type.TypeSexo;

public class UsuarioNull implements IUsuarioModel {

	@Override
	public String getFoto() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public String getSenha() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public TypePermissao getPermissao() {
		// TODO Auto-generated method stub
		return TypePermissao.INDEFINIDO;
	}

	@Override
	public TypeSexo getSexo() {
		// TODO Auto-generated method stub
		return TypeSexo.INDEFINIDO;
	}

	@Override
	public Integer getIdUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "-";
	}

	

	@Override
	public String toString() {
		return "UsuarioNull [getFoto()=" + getFoto() + ", getSenha()=" + getSenha() + ", getPermissao()="
				+ getPermissao() + ", getSexo()=" + getSexo() + ", getIdUsuario()=" + getIdUsuario() + ", getEmail()="
				+ getEmail() + ", getNome()=" + getNome() + ", getEndereco()=" + getEndereco() + ", getAnotacoes()=" + getAnotacoes() + "]";
	}

	@Override
	public Endereco getEndereco() {
		// TODO Auto-generated method stub
		return new Endereco();
	}

	@Override
	public List<Anotacao> getAnotacoes() {
		// TODO Auto-generated method stub
		return new ArrayList<Anotacao>();
	}

}
