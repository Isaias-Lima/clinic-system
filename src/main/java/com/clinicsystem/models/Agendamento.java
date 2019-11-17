package com.clinicsystem.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Medico medico;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataAgenda = new Date(System.currentTimeMillis());
	
	@ManyToOne
	private Paciente paciente;

	public Agendamento() {
	}

		
	public Agendamento(int id, Medico medico, Date dataAgenda, Paciente paciente) {
		super();
		this.id = id;
		this.medico = medico;
		this.dataAgenda = dataAgenda;
		this.paciente = paciente;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Date getDataAgenda() {
		return dataAgenda;
	}


	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	

}
