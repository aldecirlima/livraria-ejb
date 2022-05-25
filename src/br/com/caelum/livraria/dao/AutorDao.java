package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

//	Com EJB Utilizamos a anotação @PersistenceContext no lugar de @Inject para o EntityManager.
	@PersistenceContext
	private EntityManager manager;

	// Ao anotarmos o método com @PostConstruc o método será chamado pelo EJB logo
	// após a criação do sessionBean
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado.");
	}

	public void salva(Autor autor) {

//		System.out.println("Salvando autor " + autor.getNome());

//		try {
//			Thread.sleep(2000); // 2s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		manager.persist(autor);

//		System.out.println("Salvou autor " + autor.getNome());
	}

	public List<Autor> todosAutores() {
		return this.manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return this.manager.find(Autor.class, autorId);
	}

}
