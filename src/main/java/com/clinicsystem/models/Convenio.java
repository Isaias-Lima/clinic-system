package com.clinicsystem.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "convenios")
public class Convenio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nomeConvenio;
	
	@OneToMany(mappedBy="convenio")
	private List<Paciente> pacientes;

	public Convenio() {
		super();
	}

	public Convenio(int id, String nomeConvenio) {
		super();
		this.id = id;
		this.nomeConvenio = nomeConvenio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

}
