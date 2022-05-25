package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaPeloLogin(String login) {

		return (Usuario) manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login")
				.setParameter("login", login).getSingleResult();

	}

}
