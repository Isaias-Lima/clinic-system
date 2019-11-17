package com.clinicsystem.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="medicosDias")
public class MedicoDias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataAgenda = new Date(System.currentTimeMillis());
	
	public MedicoDias() {
		super();
	}

	public MedicoDias(int id, String nome, Date dataAgenda) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataAgenda = dataAgenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

}
