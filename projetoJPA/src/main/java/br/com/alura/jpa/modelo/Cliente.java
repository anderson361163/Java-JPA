package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String profissao;
	private String endereco;
	

	/* Por padr�o o OneToOne n�o torna unica as chave, para isso
	 * deve-se usar a anota��o @JoinColumn, por�m ele s� tem efeito, 
	 * quando ele � criado junto do schema
	 */
	@JoinColumn(unique = true)
	/* CADA CLIENTE S� PODE TER APENAS UMA CONTA
	 *  E CADA CONTA S� PODE TER APENAS UM CLIENTE
     */
	@OneToOne
	private Conta conta;
	
	//private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}

}
