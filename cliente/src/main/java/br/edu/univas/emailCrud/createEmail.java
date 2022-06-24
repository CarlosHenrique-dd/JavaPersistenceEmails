package br.edu.univas.emailCrud;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.edu.univas.models.Email;
import br.edu.univas.models.Usuario;
import br.edu.univas.utils.HibernateUtil;

public class createEmail {
	
	@SuppressWarnings("static-access")
	public void cadEmail() {
		Scanner sc = new Scanner(System.in);
		EntityManager em = new HibernateUtil().getEntityManager();
		
		System.out.println("Qual o Id do Usuario que vai mandar o Email ?");
		int aux = sc.nextInt();
		Usuario objUser = em.find(Usuario.class, aux);
		
		if(objUser != null) {
			Email mail = new Email();
			
			mail.setData(new Date());
			
			System.out.println("digite a mensagem");
			mail.setConteudo(sc.next());
			
			mail.setUser(objUser);
			
			em.getTransaction().begin();
			em.persist(mail);
			em.getTransaction().commit();
		}else {
			System.out.println("Id nao encontrado");
		}
		
		sc.close();
		
	}
	

}
