package entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "anotacao")
public class Anotacao {

	static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAnotacao;
	@Column
	private String nome;
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;

	public Anotacao() {
		// TODO Auto-generated constructor stub
	}

	public Anotacao(Integer idAnotacao, String nome, Date data) {
		super();
		this.idAnotacao = idAnotacao;
		this.nome = nome;
		this.data = data;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
