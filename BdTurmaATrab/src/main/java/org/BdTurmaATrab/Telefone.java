package org.BdTurmaATrab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@SuppressWarnings("deprecation")
@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int DDD;
	private int numero;
	private String tipo;
	@ManyToOne
	@JoinColumn(name = "cliente", nullable=false)
	@ForeignKey(name="cliente_fk")
	private Cliente cliente = new Cliente();
	
	public Telefone() {}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int dDD) {
		DDD = dDD;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}
	
}
