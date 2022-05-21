package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;
	
	// Ao anotarmos o método com @PostConstruc o método será chamado pelo EJB logo
	// após a criação do sessionBean
	@PostConstruct 
	void aposCriacao() {
		System.out.println("AutorDao foi criado.");
	}

	public void salva(Autor autor) {
		
		System.out.println("Salvando autor " + autor.getNome());
		
//		try {
//			Thread.sleep(2000); // 2s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		banco.save(autor);
		
		System.out.println("Salvou autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
