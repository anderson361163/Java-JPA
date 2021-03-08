package br.com.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	
	
	
	@Override
	public String toString() {
		return "\nCategoria [id=" + id + ",\n nome=" + nome + "]";
	}


	/* Por padrão o Spring precisa inicializar 
	*  as suas Entity pelo construtor padrão,
	*  por isso, para sinalizar que determinado trecho
	*  de código não deve ser utilizado pelos programadores
	*  deve se usar a anotação abaixo
	*/
	@Deprecated
	public Categoria() {
		
	}
	
	
	/* Um atalho para gerar construtores é pressionar
	 * CTRL+3
	 */
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
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
	
	
}
