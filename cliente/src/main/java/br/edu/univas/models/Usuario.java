package br.edu.univas.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id_user;
	private String login;
	private String senha;
	
	@OneToOne(mappedBy="usuario")
	private DetalhesUsuario detalhesUsuario;
	@OneToMany(mappedBy="user")
	private Set<Email> emails;
	
	public Usuario() {
		
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public DetalhesUsuario getDetalhesUsuario() {
		return detalhesUsuario;
	}

	public void setDetalhesUsuario(DetalhesUsuario detalhesUsuario) {
		this.detalhesUsuario = detalhesUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id_user=" + id_user + ", login=" + login + ", senha=" + senha + ", detalhesUsuario="
				+ detalhesUsuario + "]";
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	
	
	
	
	
	

}
