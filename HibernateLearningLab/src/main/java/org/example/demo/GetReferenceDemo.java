package org.example.demo;

import org.example.entity.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetReferenceDemo {

    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(org.example.entity.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Laptop laptop = session.getReference(Laptop.class,2);
        System.out.println(laptop);
        session.close();

        sf.close();


    }
}
