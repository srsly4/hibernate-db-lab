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
        Supplier supplier = new Supplier("test company 1",
                new Address("Krakow", "00-999", "Lea"));
        session.save(supplier);

        Category cat = new Category("test category");


        Product testProduct = new Product("test prod cascade source", 5, cat);
        testProduct.setSupplier(supplier);

        testProduct.addTransaction(new SalesTransaction(1234, 1));
        testProduct.addTransaction(new SalesTransaction(1235, 2));
        session.save(testProduct); // saves product and transactions


        SalesTransaction testTransaction = new SalesTransaction(2345, 5);
        testTransaction.addProduct(new Product("test prod cascade 1", 3, supplier, cat));
        testTransaction.addProduct(new Product("test prod cascade 2", 2, supplier, cat));
        session.save(testTransaction); // saves transaction and products

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