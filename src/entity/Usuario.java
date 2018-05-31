package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuario;
	@Column(length = 50)
	@Pattern(regexp="[a-z A-Z]{2,50}" , message="Error no nome")
	private String nome;
	@Column(length = 50, unique = true)
	@Pattern(regexp="^.+@.+\\.[a-z]+$",message="deu ruim no email")
	private String email;
	@Column
	private Integer senha;
	@Column(columnDefinition=" enum('m','f')")
	private String sexo;
	@Column
	private String foto;
	@Column
	private String permissao;

	@ManyToOne()
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Usuario() {

	}

	public Usuario(Integer idUsuario, String nome, String email, Integer senha, String sexo, String foto,
			String permissao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.foto = foto;
		this.permissao = permissao;
	}

	public Usuario(Integer idUsuario, String nome, String email, Integer senha, String sexo, String foto,
			String permissao, Endereco endereco) {
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
	
	

	public Usuario(String nome, String email, Integer senha, String sexo, String foto, String permissao) {
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
				+ ", sexo=" + sexo + ", permissao=" + permissao + ", endereco=" + endereco + "]";
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
