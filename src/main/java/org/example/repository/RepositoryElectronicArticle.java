package org.example.repository;

import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RepositoryElectronicArticle {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryElectronicArticle() {

        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }
}
