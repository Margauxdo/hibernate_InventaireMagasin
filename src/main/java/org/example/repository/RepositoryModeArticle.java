package org.example.repository;

import org.example.entity.ElectronicArticle;
import org.example.entity.ModeArticle;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RepositoryModeArticle {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryModeArticle() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public ModeArticle createMode (ModeArticle  modeArticle) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(modeArticle);
            session.getTransaction().commit();
            return modeArticle;

        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    public ModeArticle findModeArticleById (int id) {
        session = sessionFactory.openSession();
        ModeArticle modeArticle = session.get(ModeArticle.class, id);
        session.close();
        return modeArticle;
    }
    public List<ModeArticle> findAllModeArticle() {
        session = sessionFactory.openSession();
        Query<ModeArticle> query = session.createQuery("select M from ModeArticle as M", ModeArticle.class);
        List<ModeArticle> modeArticleList = query.getResultList();
        session.close();
        return modeArticleList;
    }
    public ModeArticle updateModeArticle (ModeArticle modeArticle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(modeArticle);
        session.getTransaction().commit();
        return modeArticle;
    }
    public void deleteModeArticle (ModeArticle modeArticle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(modeArticle);
        session.getTransaction().commit();

    }

}
