package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	
	public static void main(String[] args) {
		
		//Transient (classe sem vinculo com o JPA)
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(123123);
		conta.setAgencia(12387128);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Transient -> Managed
		em.persist(conta);
		
		//Managed -> Removed
		/* A conta perdeu a referencia com o banco, 
		 * Porém ela ainda existe
		 */
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
