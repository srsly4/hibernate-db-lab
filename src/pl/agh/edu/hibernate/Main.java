package pl.agh.edu.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();


        Transaction tx = session.beginTransaction();
//        Product product = new Product("auto-created product", 99);
        Supplier supplier = new Supplier("test company", "test street", "Krakow");


        Product product = session.load(Product.class, 1);

        product.setSupplier(supplier);
        session.save(supplier);
        session.save(product);
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