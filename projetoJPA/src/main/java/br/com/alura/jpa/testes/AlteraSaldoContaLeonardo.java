package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaDoLeonardo = em.find(Conta.class, 1L);
		
		System.out.println("Conta do Leonardo: " + contaDoLeonardo.getTitular());
		
		/* APÓS REALIZADO A BUSCA(FIND), O OBJETO CRIA UM LINK DE REFERENCIA COM O REGISTRO NO BANCO,
		 * PERMETINDO QUE DENTRO DO MESMO REGISTRO SEJA ALTERADO SEM PRECISAR CHAMAR OUTRO METODO DO JPA
		 * ESTE TIPO DE LINK DE REFERENCIA É CHAMADO DE "MANAGED"
		 */
		/**
		 * o STATUS MANAGED TAMBÉM PODE OCORRER TAMBÉM NO PERSISTE, APÓS A INSERÇÃO, CASO HAJA ALGUMA 
		 * ALTERAÇÃO DENTRO DO TRANSAÇÃO, ELE VAI GERAR UM UPDATE NOVAMENTE.
		 */
		em.getTransaction().begin();
		
		contaDoLeonardo.setSaldo(20.0);
		
		em.getTransaction().commit();
		
		
	}
}
