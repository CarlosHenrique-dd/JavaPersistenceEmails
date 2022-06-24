package br.edu.univas.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DetalhesUsuario implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String cpf;
	private String nome;
	private String telefone;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private Usuario usuario;
	
	public DetalhesUsuario() {
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DetalhesUsuario [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", usuario=" + usuario
				+ "]";
	}

	
	
}
