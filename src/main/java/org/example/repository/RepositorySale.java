package org.example.repository;

import org.example.entity.Sale;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RepositorySale {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositorySale() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Sale createSale (Sale sale) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(sale);
            session.getTransaction().commit();
            return sale;

        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    public Sale findSaleById (int id) {
        session = sessionFactory.openSession();
        Sale sale= session.get(Sale.class, id);
        session.close();
        return sale;
    }
    public List<Sale> findAllSale() {
        session = sessionFactory.openSession();
        Query<Sale> query = session.createQuery("select S from Sale as S", Sale.class);
        List<Sale> saleList = query.getResultList();
        session.close();
        return saleList;
    }
    public int updateSale (int sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(sale);
        session.getTransaction().commit();
        return sale;
    }
    public void deleteSale (Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(sale);
        session.getTransaction().commit();

    }


}
