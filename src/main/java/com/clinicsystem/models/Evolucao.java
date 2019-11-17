package com.clinicsystem.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="evolucoes")
public class Evolucao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro = new Date(System.currentTimeMillis());
	private long comentario;

	public Evolucao() {
	}

	public Evolucao(int id, Date data, long comentario) {
		super();
		this.id = id;
		this.dataCadastro = data;
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Date getData() {
		return dataCadastro;
	}

	public void setData(Date data) {
		this.dataCadastro = data;
	}

	public long getComentario() {
		return comentario;
	}

	public void setComentario(long comentario) {
		this.comentario = comentario;
	}

}
