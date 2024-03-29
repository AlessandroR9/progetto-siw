package it.uniroma3.model;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Attivita {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private GregorianCalendar data;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="hh-mm")
	private Date orario;
	
	@OneToMany
	private List<Allievo> allievi;
	
	@ManyToOne
	private Centro centro;
	
	public Attivita() {
	}

	public Attivita(Long id, String nome, GregorianCalendar data, Date orario, List<Allievo> allievi, Centro centro){
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.orario = orario;
		this.allievi = allievi;
		this.centro = centro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public Date getOrario() {
		return orario;
	}

	public void setOrario(Date orario) {
		this.orario = orario;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	
}
