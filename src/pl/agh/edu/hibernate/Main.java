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
        Supplier supplier = new Supplier("test company 1", "test street", "Krakow");
        Supplier supplier2 = new Supplier("test company 2", "test street", "Krakow");

        Category cat = new Category("test category");

        supplier.addProduct(new Product("test prod 1", 1, cat));
        supplier.addProduct(new Product("test prod 2", 2, cat));
        supplier.addProduct(new Product("test prod 3", 3, cat));
        supplier.addProduct(new Product("test prod 4", 4, cat));
        Product product = new Product("test prod 5", 5, cat);
        supplier2.addProduct(product);

        session.save(supplier);
        session.save(supplier2);

        System.out.println("Produkty od " + supplier.getCompanyName());
        for (Product p : supplier.getProducts()) {
            System.out.println(p.getProductName());
        }

        product = session.load(Product.class, product.getDbId());
        System.out.println("Dostawca dla produktu " + product.getProductName());
        System.out.println(product.getSupplier().getCompanyName());

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