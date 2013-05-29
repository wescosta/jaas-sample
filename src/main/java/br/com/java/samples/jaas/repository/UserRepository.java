package br.com.java.samples.jaas.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.java.samples.jaas.model.User;

@Stateless
public class UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(User user) {
		em.persist(user);
	}
	
	public List<User> list() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}
	
}