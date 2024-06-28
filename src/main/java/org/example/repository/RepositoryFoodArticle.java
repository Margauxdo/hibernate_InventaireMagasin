package org.example.repository;

import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RepositoryFoodArticle {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryFoodArticle() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }
}
