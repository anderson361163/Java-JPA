package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		
		//OBRIGAT�RIO ESTAR DENTRO DE UMA TRANSA��O
		//NO JDBC ELE J� � AUTO COMMITE
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
	}

}
