package com.vtb.zolotarev.spring.mvc.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryComponent {
    SessionFactory sessionFactory;
    @PostConstruct
    public void init(){
        sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
