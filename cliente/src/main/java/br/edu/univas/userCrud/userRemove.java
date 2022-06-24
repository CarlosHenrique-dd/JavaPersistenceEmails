package br.edu.univas.userCrud;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.edu.univas.models.DetalhesUsuario;
import br.edu.univas.models.Usuario;
import br.edu.univas.utils.HibernateUtil;

public class userRemove {

	@SuppressWarnings("unused")
	public void remove(int i) {
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = HibernateUtil.getEntityManager();
		
		int pkUser = i ;
		Usuario objUser= em.find(Usuario.class, pkUser);
		
		String pkDet = objUser.getDetalhesUsuario().getCpf();
		DetalhesUsuario objDet = em.find(DetalhesUsuario.class, pkDet);
		
		if(objUser != null) {
			em.getTransaction().begin();
			em.remove(objDet);
			em.remove(objUser);
			em.getTransaction().commit();
		}
		else {
			System.out.println("Id "+ pkUser);
		}
		
		sc.close();
		
	}
}
