package br.edu.univas.userCrud;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.edu.univas.models.DetalhesUsuario;
import br.edu.univas.models.Usuario;
import br.edu.univas.utils.HibernateUtil;

public class CadastroUser {
	
	public void cadCheck() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o login");
		String login = sc.nextLine();
		
		System.out.println("Digite a senha");
		String senha = sc.nextLine();
		
		System.out.println("Digite o nome");
		String nome = sc.nextLine();
		
		System.out.println("Digite o CPF");
		String CPF = sc.nextLine();
		
		System.out.println("Digite o telefone");
		String telefone = sc.nextLine();
		
		CadastroUser cad = new CadastroUser();
		
		cad.cadastro(login,senha,nome,CPF,telefone);
		
		sc.close();
		
	}

	public void cadastro(String login, String senha, String nome, String cPF, String telefone) {
	
		EntityManager em = HibernateUtil.getEntityManager();
		
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setSenha(senha);
		
		DetalhesUsuario detUser = new DetalhesUsuario();
		detUser.setCpf(cPF);
		detUser.setNome(nome);
		detUser.setTelefone(telefone);
		
		detUser.setUsuario(user);
		
		em.getTransaction().begin();
		em.persist(user);
		em.persist(detUser);
		em.getTransaction().commit();
		
	}
	
}
