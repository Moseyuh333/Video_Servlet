package com.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public abstract class AbstractDAO<T> {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoServlentPU");
    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T findById(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void update(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<T> findByNamedQuery(String namedQuery, Object... params) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery(namedQuery);
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findWithPagination(int page, int size) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public long count() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e");
            return (Long) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
