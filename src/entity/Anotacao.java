package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "anotacao")
public class Anotacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAnotacao;
	@Column
	private String nome;
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToOne()
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Anotacao() {
		// TODO Auto-generated constructor stub
	}

	public Anotacao(Integer idAnotacao, String nome, Date data) {
		super();
		this.idAnotacao = idAnotacao;
		this.nome = nome;
		this.data = data;
	}

	public Anotacao(Integer idAnotacao, String nome, Date data, Usuario usuario) {
		super();
		this.idAnotacao = idAnotacao;
		this.nome = nome;
		this.data = data;
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Anotacao [idAnotacao=" + idAnotacao + ", nome=" + nome + ", data=" + data + "]";
	}

	public Integer getIdAnotacao() {
		return idAnotacao;
	}

	public void setIdAnotacao(Integer idAnotacao) {
		this.idAnotacao = idAnotacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return SDF.format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
