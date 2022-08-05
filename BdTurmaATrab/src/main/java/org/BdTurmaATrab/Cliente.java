package org.BdTurmaATrab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String data_nascimento;
	private String sexo;
	private String cpf;
	@OneToOne
	private Endereco endereco;
	@OneToMany(mappedBy = "cliente", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Cliente() {}
	
	public Cliente(String nome, String data_nascimento, String sexo, String cpf, Endereco endereco){
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Long getId() {
		return id;
	}
	
}
