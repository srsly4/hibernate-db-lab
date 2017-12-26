package pl.agh.edu.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        Product product2 = new Product("test prod 6", 5, cat);
        supplier2.addProduct(product);
        supplier2.addProduct(product2);

        session.save(supplier);
        session.save(supplier2);

        SalesTransaction salesTransaction = new SalesTransaction(2313, 2);
        salesTransaction.addProduct(product2);
        SalesTransaction salesTransaction2 = new SalesTransaction(2314, 2);
        salesTransaction2.addProduct(product2);
        salesTransaction2.addProduct(product);


        session.save(salesTransaction);
        session.save(salesTransaction2);

        SalesTransaction testTransaction = session.get(SalesTransaction.class, salesTransaction2.getTransactionId());
        Product testProduct = session.get(Product.class, product2.getDbId());

        System.out.println("Produkty sprzedane w ramach przykładowej transakcji #"
                + testTransaction.getTransactionNumber() + ":");
        for (Product p : testTransaction.getProducts()) {
            System.out.println(p.getProductName());
        }

        System.out.println("Transakcje, w ramach których sprzedany był produkt " + testProduct.getProductName());
        for (SalesTransaction t : testProduct.getSalesTransactions()) {
            System.out.println(String.valueOf(t.getTransactionNumber()));
        }

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