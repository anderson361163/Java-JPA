package br.com.alura.jpa.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("José");
		cliente.setEndereco("Rua do ouvidor, 50");
		cliente.setProfissao("Professor");
		cliente.setConta(conta);
		
		//------------------------------
		
		Cliente cliente2 = new Cliente();
		
		cliente2.setNome("Fernanda");
		cliente2.setEndereco("Rua do Rosário, 60");
		cliente2.setProfissao("Professora");
		cliente2.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
		

	}

}
