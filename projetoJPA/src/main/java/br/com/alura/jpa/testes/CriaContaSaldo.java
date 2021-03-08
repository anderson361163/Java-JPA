package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaSaldo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		conta.setSaldo(500.0);
		
		
		//-----------------------------
		Conta conta2 = new Conta();
		conta2.setTitular("Reinaldo");
		conta2.setNumero(4321);
		conta2.setAgencia(4321);
		conta2.setSaldo(1000.0);
		
		//OBRIGAT�RIO ESTAR DENTRO DE UMA TRANSA��O
		//NO JDBC ELE J� � AUTO COMMITE
		
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(conta2);
		
		em.getTransaction().commit();
		em.close();
		
		
		/* SER� POSSIVEL VER O ID DA CONTA2 PORQUE ELA J� FOI MANAGED, 
		 * POR�M N�O � MAIS, POR ISSO ELA PODE SER MAIS ALTERADA,
		 * POR ISSO � CHAMADA DE DETACHED (OBJETO QUE N�O POSSUI MAIS REFERENCIA)
		 */
		System.out.println("ID da conta da M�rcia: " + conta2.getId());
		conta2.setSaldo(500.0);
		
		/**
		 * PARA TORNAR A CONTA 2 COMO MANAGED NOVAMENTE � NECESS�RIO A ABERTURA DE UM NOVO
		 * ENTITYMANAGER
		 */
		EntityManager em2 = emf.createEntityManager();
		
		em2.getTransaction().begin();
		
		/* PARA OBTER A REFERENCIA NOVAMENTE ELE VAI BUSCAR
		 * NOVAMENTE ESSE REGISTRO E PEGAR A REFERENCIA
		 */
		em2.merge(conta2);
		
		em2.getTransaction().commit();
		
		
		
		
	}

}
