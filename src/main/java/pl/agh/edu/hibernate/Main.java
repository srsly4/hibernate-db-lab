package pl.agh.edu.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.agh.edu.hibernate.model.Company;
import pl.agh.edu.hibernate.model.Customer;
import pl.agh.edu.hibernate.model.Product;
import pl.agh.edu.hibernate.model.Supplier;

import static spark.Spark.*;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        get("/", (req, res) -> "Hello world!");
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}