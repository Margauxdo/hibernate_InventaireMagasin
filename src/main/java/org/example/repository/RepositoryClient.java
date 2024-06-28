package org.example.repository;

import org.example.entity.Client;
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
        Client client = session.get(Client.class, id);
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
}

//cree, affcher la liste, afficher par id, modifié, supprimé