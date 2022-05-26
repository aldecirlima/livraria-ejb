package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.exception.LivrariaException;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao autorDao;

	public void adiciona(Autor autor) {

		// Regras de negócio aqui
		try {
			autorDao.salva(autor);

		} catch (Exception e) {
			throw new LivrariaException();
		}

	}

	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}

}
