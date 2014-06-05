package com.ttu.roman.dao.abstractions;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

public abstract class AbstractFacade<T> {

	private final Class<T> entityClass;

	@PersistenceContext
    protected EntityManager em;

	public AbstractFacade(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

    @Transactional
	public void create(final T entity) {
        em.persist(entity);
	}

    @Transactional
	public void update(final T entity) {
        em.merge(entity);
	}

	public void delete(final T entity) {
		try {
            em.remove(em.merge(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<T> findAll() {
		try {
            return em.createQuery(
                    "SELECT e FROM " + entityClass.getName() + " e",
                    entityClass).getResultList();
		} catch (Exception e) {
            e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public T find(final int id) {
        return em.find(entityClass, id);
	}

	public long count() {
        return ((Long) em.createQuery(
                "select count(e) from " + entityClass.getName() + " as e")
				.getSingleResult()).longValue();
	}

	public void flushEm() {
        em.flush();
	}

    public void setEm(final EntityManager em) {
		this.em = em;
	}
}