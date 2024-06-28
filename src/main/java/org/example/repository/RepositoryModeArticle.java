package org.example.repository;

import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RepositoryModeArticle {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryModeArticle() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }
}
