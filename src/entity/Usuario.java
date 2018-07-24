package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import ctrlPattern.IUsuarioModel;
import type.TypePermissao;
import type.TypeSexo;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable, IUsuarioModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	@Column(length = 50, nullable= false)
	@Pattern(regexp = "[a-z A-Z]{2,50}", message = "Error no nome")
	private String nome;
	@Column(length = 50, unique = true, nullable= false)
	@Pattern(regexp = "^.+@.+\\.[a-z]+$", message = "deu ruim no email")
	private String email;
	@Column(length = 50, nullable= false)
	private String senha;
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable= false)
	private TypeSexo sexo;
	@Column
	private String foto;
	@Enumerated(EnumType.STRING)
	@Column(length= 15, nullable= false)
	private TypePermissao permissao;

	@ManyToOne()
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToOne()
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	@OneToMany(mappedBy = "usuario")
	private List<Anotacao> anotacoes;

	public Usuario() {

	}

	public Usuario(Integer idUsuario, String nome, String email, String senha, TypeSexo sexo, String foto,
			TypePermissao permissao, Endereco endereco, Perfil perfil, List<Anotacao> anotacoes) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.foto = foto;
		this.permissao = permissao;
		this.endereco = endereco;
		this.perfil = perfil;
		this.anotacoes = anotacoes;
	}

	public Usuario(Integer idUsuario, String nome, String email, String senha, TypeSexo sexo, String foto,
			TypePermissao permissao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.foto = foto;
		this.permissao = permissao;
	}

	public Usuario(Integer idUsuario, String nome, String email, String senha, TypeSexo sexo, String foto,
			TypePermissao permissao, Endereco endereco, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.foto = foto;
		this.permissao = permissao;
		this.endereco = endereco;
		this.perfil = perfil;
	}

	public Usuario(Integer idUsuario, String nome, String email, String senha, TypeSexo sexo, String foto,
			TypePermissao permissao, Endereco endereco) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.foto = foto;
		this.permissao = permissao;
		this.endereco = endereco;
	}

	public Usuario(String nome, String email, String senha, TypeSexo sexo, String foto, TypePermissao permissao) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.foto = foto;
		this.permissao = permissao;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", sexo=" + sexo + ", foto=" + foto + ", permissao=" + permissao + ", endereco=" + endereco
				+ ", perfil=" + perfil + "]";
	}

	public void removerAnotacao(Anotacao nota) {
		anotacoes.remove(nota);
	}

	public void addAnotacao(Anotacao... notas) {
		if (anotacoes == null) {
			anotacoes = new ArrayList<Anotacao>();
		}
		for (Anotacao x : notas) {
			anotacoes.add(x);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Anotacao> getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(List<Anotacao> anotacoes) {
		this.anotacoes = anotacoes;
	}

	@Override
	public TypeSexo getSexo() {
		return sexo;
	}

	public void setSexo(TypeSexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public TypePermissao getPermissao() {
		// TODO Auto-generated method stub
		return permissao;
	}

	public void setPermissao(TypePermissao permissao) {
		this.permissao = permissao;
	}
	
}