package org.example.repository;

import org.example.entity.Article;
import org.example.entity.ElectronicArticle;
import org.example.entity.FoodArticle;
import org.example.util.SessionfactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class RepositoryFoodArticle {
    private SessionFactory sessionFactory;
    private Session session;

    public RepositoryFoodArticle() {
        sessionFactory = SessionfactorySingleton.getSessionFactory();


    }

    public FoodArticle createFood(FoodArticle foodArticle) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(foodArticle);
            session.getTransaction().commit();
            return foodArticle;

        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public FoodArticle findFoodArticleById(int id) {
        session = sessionFactory.openSession();
        FoodArticle foodArticle = session.get(FoodArticle.class, id);
        session.close();
        return foodArticle;
    }

    public List<FoodArticle> findAllFoodArticle() {
        session = sessionFactory.openSession();
        Query<FoodArticle> query = session.createQuery("select F from FoodArticle as F", FoodArticle.class);
        List<FoodArticle> foodArticleList = query.getResultList();
        session.close();
        return foodArticleList;
    }

    public FoodArticle updateFoodArticle(FoodArticle foodArticle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(foodArticle);
        session.getTransaction().commit();
        return foodArticle;
    }

    public void deleteFoodArticle(FoodArticle foodArticle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(foodArticle);
        session.getTransaction().commit();

    }

    public void restockArticle(int id, int quantity) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Article article = session.get(Article.class, id);
        try {
            int currentQtity = article.getQuantity();
            int newQtity = currentQtity + quantity;
            article.setQuantity(newQtity);
            article.setDateRenewalStock(LocalDate.now());
            session.update(article);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
