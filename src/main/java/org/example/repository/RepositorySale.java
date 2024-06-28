package org.example.repository;

import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RepositorySale {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositorySale() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }
}
