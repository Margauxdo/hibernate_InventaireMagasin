package org.example.repository;

import org.example.entity.Client;
import org.example.entity.Sale;
import org.example.util.Category;
import org.example.util.SaleCondition;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class RepositoryClient {

    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryClient() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();
    }

    public Client createClient (Client client) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            return client;

        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    public Client findClientById (int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = session.find(Client.class, id);
        session.getTransaction().commit();
        session.close();
        return client;
    }
    public List<Client> findAllClients() {
        session = sessionFactory.openSession();
        Query<Client> query = session.createQuery("select C from Client as C", Client.class);
        List<Client> clients = query.getResultList();
        session.close();
        return clients;
    }
    public Client updateClient (Client client) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        return client;
    }
    public void deleteClient (Client client) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();

    }


    public List<Sale> salesRepport(int id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Sale> query = session.createQuery("select c.saleList from Client c where c.id=?1 ",Sale.class)
                .setParameter(1, id);
        List<Sale> sales = query.getResultList();
        return sales;
    }
}

