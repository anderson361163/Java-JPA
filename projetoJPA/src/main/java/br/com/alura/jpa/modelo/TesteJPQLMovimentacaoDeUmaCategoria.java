package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();


		Conta conta = new Conta();

		conta.setId(2L);

		String jpql = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria";

		Categoria categoria = new Categoria();
		categoria.setId(2L);
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);


		List<Movimentacao> resultList = query.getResultList();

		for(Movimentacao movimentacao : resultList) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("-------------------------------------------------");
		}





	}

}
