package com.clinicsystem.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.PageRequest;

@Entity
@Table(name="pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private static String nome;
	private String estadoCivil;
	private String matricula;
	private String naturalidade;
	private String bairro;
	private String cep;
	private String cidade;
	private String fone;
	private String dataNascimento;
	private String idade;
	private String profissao;
	
	@CPF
	private String cpf;
	
	@Email
	private String email;
	private String observacao;
	private String rg;
	
	@ManyToOne
	private Convenio convenio;
	
	@ManyToOne
	private Medico medico;
	
	@ManyToMany
	@JoinTable(name="pacientes_enderecos")
	private List<Endereco> enderecos;
	
	@OneToMany(mappedBy="paciente")
	private List<Agendamento> agendamentos;
	
	@OneToMany(mappedBy="paciente")
	private List<Anamnese> anamneses;

	public Paciente() {
		super();
	}

	public Paciente(int id, String nome, String estadoCivil, String matricula, String natural, String bairro,
			String cep, String cidade, String fone, String dataNascimento, String idade,
			String profissao, @CPF String cpf, @Email String email, String observacao, String rg) {
		super();
		this.id = id;
		Paciente.nome = nome;
		this.estadoCivil = estadoCivil;
		this.matricula = matricula;
		this.naturalidade = natural;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.fone = fone;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.profissao = profissao;
		this.cpf = cpf;
		this.email = email;
		this.observacao = observacao;
		this.rg = rg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		Paciente.nome = nome;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNatural() {
		return naturalidade;
	}

	public void setNatural(String natural) {
		this.naturalidade = natural;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Object buscarPorPaciente(PageRequest of, Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

	public Paciente orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
