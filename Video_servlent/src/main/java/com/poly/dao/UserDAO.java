package com.poly.dao;

import com.poly.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO() {
        super(User.class);
    }

    public User findByUsername(String username) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }


}
