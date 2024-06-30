package org.example.repository;

import org.example.entity.Client;
import org.example.entity.ElectronicArticle;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RepositoryElectronicArticle {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryElectronicArticle() {

        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }


    public ElectronicArticle createElectronic (ElectronicArticle electronicArticle) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(electronicArticle);
            session.getTransaction().commit();
            return electronicArticle;

        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    public ElectronicArticle findElectronicArticleById (int id) {
        session = sessionFactory.openSession();
        ElectronicArticle electronicArticle= session.get(ElectronicArticle.class, id);
        session.close();
        return electronicArticle;
    }
    public List<ElectronicArticle> findAllElectronicArticle() {
        session = sessionFactory.openSession();
        Query<ElectronicArticle> query = session.createQuery("select E from ElectronicArticle as E", ElectronicArticle.class);
        List<ElectronicArticle> electronicArticleList = query.getResultList();
        session.close();
        return electronicArticleList;
    }
    public ElectronicArticle updateElectronicArticle (ElectronicArticle electronicArticle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(electronicArticle);
        session.getTransaction().commit();
        return electronicArticle;
    }
    public void deleteElectronicArticle (ElectronicArticle electronicArticle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(electronicArticle);
        session.getTransaction().commit();

    }

}
