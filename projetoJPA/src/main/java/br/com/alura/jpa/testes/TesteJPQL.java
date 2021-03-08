package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		
		Conta conta = new Conta();
		
		conta.setId(2L);
		
		
		/* AQUI EU QUERO CONSULTAR SE NA CHAVE ESTRANGEIRA DE MOVIMENTACAO EXISTE 
		 * UM ID DE CONTA IGUAL A 2
		 */
		/* Para definir parametros basta colocar : na frente, contudo por conv�n��o,
		 * o nome dos parametros come�a com "p" de parametro 
		 */
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta ORDER BY m.valor DESC";
		
		//ENTITYMANAGER VAI EXECUTAR A QUERY E JOGAR O RESULTADO DENTRO DO OBJETO QUERY
		/* 1.1 ))Para evitar erros de tempo de execu��o, o uso do TypedQuery e declarando o tipo de classe
		 * de retorno se torna muito importante, lembre-se aqui � programa��o orientada a objeto
		 */
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		//O OBJETO QUERY VAI GERAR UMA LISTA DO TIPO MOVIMENTACAO
		
		/* 1)) O MOTIVO DO WARNING ABAIXO SE DEVE AO FATO QUE O OBJETO QUERY
		 * S� IR� SABER QUAL O TIPO DE LISTA QUE ELE IR� RECEBER EM 
		 * TEMPO DE EXECU��O, PARA ISSO, DEVE-SE TROCAR A CLASSE DE QUERY PARA 
		 * O TIPO TYPEDQUERY
		 */
		List<Movimentacao> resultList = query.getResultList();
		
		for(Movimentacao movimentacao : resultList) {
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Descri��o: " + movimentacao.getTipoMovimentacao());
			System.out.println("-------------------------------------------------");
		}
		
	}
	
}
