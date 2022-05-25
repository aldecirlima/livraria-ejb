package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // opcional, serve apenas para fins ditaticos
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

	@TransactionAttribute(TransactionAttributeType.MANDATORY) // Quem faz uma chamada deve abrir uma trasação.
	public void salva(Autor autor) {

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
