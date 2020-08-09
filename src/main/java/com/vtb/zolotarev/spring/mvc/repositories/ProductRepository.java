package com.vtb.zolotarev.spring.mvc.repositories;

import com.vtb.zolotarev.spring.mvc.model.Product;
import com.vtb.zolotarev.spring.mvc.model.User;
import com.vtb.zolotarev.spring.mvc.utils.SessionFactoryComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactoryComponent sessionFactoryComponent) {
        this.sessionFactory = sessionFactoryComponent.getSessionFactory();
    }

    public void save(Product product) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public Product findProductById(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAllProducts() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> allProducts = new ArrayList<>(session.createQuery("SELECT p FROM Product p", Product.class).getResultList());
            session.getTransaction().commit();
            return allProducts;
        }
    }

    public void deleteProductById(long id){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
