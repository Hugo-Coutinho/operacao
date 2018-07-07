package ctrlPattern;

import entity.Anotacao;
import entity.Endereco;
import entity.Perfil;

public class UsuarioNull implements IUsuarioModel {

	@Override
	public String getFoto() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public Integer getSenha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPermissao() {
		// TODO Auto-generated method stub
		return "-";
	}

	@Override
	public String getSexo() {
		// TODO Auto-generated method stub
		return "-";
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
				+ getEmail() + ", getNome()=" + getNome() + ", getEndereco()=" + getEndereco() + ", getPerfil()="
				+ getPerfil() + ", getAnotacao()=" + getAnotacao() + "]";
	}

	@Override
	public Endereco getEndereco() {
		// TODO Auto-generated method stub
		return new Endereco();
	}

	@Override
	public Perfil getPerfil() {
		// TODO Auto-generated method stub
		return new Perfil();
	}

	@Override
	public Anotacao getAnotacao() {
		// TODO Auto-generated method stub
		return new Anotacao();
	}

}
