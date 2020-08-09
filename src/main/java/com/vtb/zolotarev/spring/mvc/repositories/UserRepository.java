package com.vtb.zolotarev.spring.mvc.repositories;

import com.vtb.zolotarev.spring.mvc.model.User;
import com.vtb.zolotarev.spring.mvc.utils.SessionFactoryComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactoryComponent sessionFactoryComponent) {
        this.sessionFactory = sessionFactoryComponent.getSessionFactory();
    }

    public void save(User user) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public User findUserById(long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }
    }

    public List<User> findAllUsers() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<User> allUsers = new ArrayList<>(session.createQuery("SELECT u FROM User u", User.class).getResultList());
            session.getTransaction().commit();
            return allUsers;
        }
    }

    public void deleteUserById(long id){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}
