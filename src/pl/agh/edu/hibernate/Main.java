package pl.agh.edu.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();


        Transaction tx = session.beginTransaction();
        Supplier supplier = new Supplier("test company", "test street", "Krakow");

        supplier.addProduct(new Product("test prod 1", 1));
        supplier.addProduct(new Product("test prod 2", 2));
        supplier.addProduct(new Product("test prod 3", 3));
        supplier.addProduct(new Product("test prod 4", 4));

        session.save(supplier);
        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Product.class);
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}