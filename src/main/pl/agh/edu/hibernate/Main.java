package pl.agh.edu.hibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Supplier supplier = new Supplier("test company 1", "test street", "Krakow");
        Supplier supplier2 = new Supplier("test company 2", "test street", "Krakow");

        Category cat = new Category("test category");

        supplier.addProduct(new Product("test prod 1", 1, cat));
        supplier.addProduct(new Product("test prod 2", 2, cat));
        supplier.addProduct(new Product("test prod 3", 3, cat));
        supplier.addProduct(new Product("test prod 4", 4, cat));
        Product product = new Product("test prod 5", 5, cat);
        supplier2.addProduct(product);

        em.persist(supplier);
        em.persist(supplier2);

        System.out.println("Produkty od " + supplier.getCompanyName());
        for (Product p : supplier.getProducts()) {
            System.out.println(p.getProductName());
        }

        product = em.find(Product.class, product.getDbId());
        System.out.println("Dostawca dla produktu " + product.getProductName());
        System.out.println(product.getSupplier().getCompanyName());

        tx.commit();
        em.close();
    }

}