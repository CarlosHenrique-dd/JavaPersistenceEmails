package br.edu.univas.userCrud;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.edu.univas.models.DetalhesUsuario;
import br.edu.univas.models.Usuario;
import br.edu.univas.utils.HibernateUtil;

public class userEdit {
	
	@SuppressWarnings("unused")
	public void edit(int i) {
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = HibernateUtil.getEntityManager();
		
		int pkUser = i ;
		Usuario objUser= em.find(Usuario.class, pkUser);
		
		String pkDet = objUser.getDetalhesUsuario().getCpf();
		DetalhesUsuario objDet = em.find(DetalhesUsuario.class, pkDet);
		
		
		if(objUser != null) {
			
			
			
			System.out.println("Digite o novo login");
			objUser.setLogin(sc.nextLine());
			
			System.out.println("Digite a nova senha");
			objUser.setSenha(sc.nextLine());
			
			System.out.println("Digite o nome");
			objDet.setNome(sc.nextLine());
			
			System.out.println("Digite o telefone");
			objDet.setTelefone(sc.nextLine()); 
		
			em.getTransaction().begin();
			em.merge(objUser);
			em.merge(objDet);
			em.getTransaction().commit();
			
		}
		else {
			System.out.println("o Id "+pkUser+" nao foi encontrado");
		}
			
		sc.close();
	}

}
