package com.carffrey.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaDao<K,E> implements Dao<K,E> {
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Class<E> entityClass;
	
	@Override
	public void persist(E entity) {
		em.persist(entity);
	}
	

	@Override
	public void remove(E entity) {
		em.refresh(entity);
	}

	@Override
	public E findbyId(K id) {
		return em.find(entityClass, id);
	}

}
