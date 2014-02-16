package com.carffrey.dao;

public interface Dao<K, E> {
	public void persist(E entity);

	public void remove(E entity);

	public E findbyId(K id);
}
