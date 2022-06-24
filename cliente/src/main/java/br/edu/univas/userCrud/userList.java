package br.edu.univas.userCrud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.univas.models.Usuario;
import br.edu.univas.utils.HibernateUtil;

public class userList {
	
	@SuppressWarnings("unchecked")
	public void getUser() {
		
		EntityManager em = HibernateUtil.getEntityManager();
		
		Query query = em.createNativeQuery("select * from usuario", Usuario.class);
		List<Usuario> lista = query.getResultList();
		
		lista.stream().forEach(u -> System.out.println(
				String.format("Usuario => Id: %s, Nome: %s",
						u.getId_user(), u.getLogin())));
	}
	
	

}
