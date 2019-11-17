package com.clinicsystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String medico;
	private String crm;
	private String observacao;
	private String endereco;
	private String bairro;
	private String cidade;
	private String uf;
	private String especialista;
	private String fone;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro = new Date(System.currentTimeMillis());

	@OneToMany(mappedBy = "medico")
	private List<Paciente> pacientes;

	@OneToMany(mappedBy = "medico")
	private List<Agendamento> agendamentos;

	public Medico() {
		super();
	}

	public Medico(int id, String medico, String crm, String observacao, String endereco, String bairro, String cidade,
			String uf, String especialista, String fone, Date dataCadastro, List<Paciente> pacientes,
			List<Agendamento> agendamentos) {
		super();
		this.id = id;
		this.medico = medico;
		this.crm = crm;
		this.observacao = observacao;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.especialista = especialista;
		this.fone = fone;
		this.dataCadastro = dataCadastro;
		this.pacientes = pacientes;
		this.agendamentos = agendamentos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEspecialista() {
		return especialista;
	}

	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

}
