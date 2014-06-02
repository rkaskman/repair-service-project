package com.ttu.roman.dao.abstractions;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

public abstract class AbstractFacade<T> {

	private final Class<T> entityClass;

	@PersistenceContext
    private EntityManager em;

	public AbstractFacade(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void create(final T entity) {
		getEm().persist(entity);
	}

	public void update(final T entity) {
		getEm().merge(entity);
	}

	public void delete(final T entity) {
		try {
			getEm().remove(getEm().merge(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<T> findAll() {
		try {
			return getEm().createQuery(
					"SELECT e FROM " + entityClass.getName() + " e",
					entityClass).getResultList();
		} catch (Exception e) {
            e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public T find(final int id) {
		return getEm().find(entityClass, id);
	}

	public long count() {
		return ((Long) getEm().createQuery(
				"select count(e) from " + entityClass.getName() + " as e")
				.getSingleResult()).longValue();
	}

	public void flushEm() {
		getEm().flush();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(final EntityManager em) {
		this.em = em;
	}
}