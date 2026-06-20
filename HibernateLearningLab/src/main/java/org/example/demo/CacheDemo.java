package org.example.demo;

import org.example.entity.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CacheDemo {

    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(org.example.entity.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Laptop l1 = session.find(Laptop.class, 2);
        System.out.println(l1);
        session.close();

        Session session1 = sf.openSession();
        Laptop l2 = session1.find(Laptop.class, 2);
        System.out.println(l2);

        session1.close();

        sf.close();


    }
}
