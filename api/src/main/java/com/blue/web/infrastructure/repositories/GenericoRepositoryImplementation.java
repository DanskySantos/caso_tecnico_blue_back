package com.blue.web.infrastructure.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class GenericoRepositoryImplementation {

    @PersistenceContext
    private EntityManager entityManager;

    protected Session getSession() {
        Session session;
        try {
            session = entityManager.unwrap(Session.class);
        } catch (Exception e) {
            session = entityManager.unwrap(Session.class).getSessionFactory().unwrap(SessionFactory.class).openSession();
        }

        return session;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}