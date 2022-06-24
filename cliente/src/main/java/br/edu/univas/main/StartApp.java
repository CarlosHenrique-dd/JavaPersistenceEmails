package br.edu.univas.main;

import java.util.Scanner;

import javax.persistence.EntityManager;

import br.edu.univas.emailCrud.createEmail;
import br.edu.univas.userCrud.CadastroUser;
import br.edu.univas.userCrud.userEdit;
import br.edu.univas.userCrud.userList;
import br.edu.univas.userCrud.userRemove;
import br.edu.univas.utils.HibernateUtil;

public class StartApp {
	
	public static Scanner sc = new Scanner(System.in);
	static int option = 0;
	public static void main(String[] args) {
		
		EntityManager em = HibernateUtil.getEntityManager();
		
		menuCad();
	
		sc.close();
		em.close();

	}
	
	public static void menuCad() {
		System.out.println("1.Cadastro User  2.Cadastro Email 9.Sair");
		int op = sc.nextInt();
		
		if(op == 1) {menuUser();}
		if(op == 2) {creatEmail();}
	}
	
	public static void menuEmail() {
		System.out.println("1.Enviar email");
		
		if(option == 1) {}
	}
	
	public static void menuUser() {
		
		do {
			System.out.println("1-Cadastrar 2-Encontrar 3-Editar 4-Remover 9-Sair");
			option = sc.nextInt();
			
			if(option == 1) {cadastro();}
			
			if(option == 2) {getUser();}
			
			if(option == 3) {editUser();}
			
			if(option == 4) {remove();}
			
		}while(option != 9);
	}
	
	public static void cadastro() {
		CadastroUser cad = new CadastroUser();
		cad.cadCheck();
	}
	
	public static void getUser() {
		userList userlist = new userList();
		userlist.getUser();
	}
	
	public static void editUser() {
		
		userList list = new userList();
		list.getUser();
		System.out.println("qual o Id do usuario que deseja editar ?");
		userEdit edit = new userEdit();
		int aux = sc.nextInt();
		edit.edit(aux);
	}
	
	public static void remove() {
		userRemove remove = new userRemove();
		System.out.println("digite o id que deseja remover");
		remove.remove(sc.nextInt());
	}
	
	public static void creatEmail(){
		createEmail cEmail = new createEmail();
		cEmail.cadEmail();
	}

}
