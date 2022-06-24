package br.edu.univas.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id_mail;
	private Date data;
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private Usuario user;
	
	public Integer getId_mail() {
		return id_mail;
	}
	public void setId_mail(Integer id_mail) {
		this.id_mail = id_mail;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
}
