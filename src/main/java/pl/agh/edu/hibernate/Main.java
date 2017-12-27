package pl.agh.edu.hibernate;


import freemarker.template.TemplateExceptionHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.agh.edu.hibernate.routes.*;

import java.util.Locale;

import static spark.Spark.*;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        freemarker.template.Configuration cfg = new freemarker.template.Configuration();

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(Main.class, "templates");

        // Some other recommended settings:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.getDefault());
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        staticFiles.location("/public");

        get("/", (req, res) -> "Hello world!");
        get("/categories", new CategoryList(session, cfg));
        get("/categories/add", new AddCategoryForm(session, cfg));
        post("/categories/add", new AddCategoryHandler(session, cfg));
        get("/products", new ProductList(session, cfg));
        get("/products/add", new AddProductForm(session, cfg));
        post("/products/add", new AddProductHandler(session, cfg));
        get("/suppliers", new SupplierList(session, cfg));
        get("/suppliers/add", new AddSupplierForm(session, cfg));
        post("/suppliers/add", new AddSupplierHandler(session, cfg));
        get("/customers", new CustomerList(session, cfg));
        get("/customers/add", new AddCustomerForm(session, cfg));
        post("/customers/add", new AddCustomerHandler(session, cfg));
        get("/transactions", new TransactionList(session, cfg));
        get("/transactions/create", new CreateTransactionHandler(session, cfg));
        get("/transactions/:transaction", new TransactionDetailsForm(session, cfg));
        post("/transactions/:transaction", new TransactionSaveHandler(session, cfg));
        post("/transactions/:transaction/addProduct", new TransactionAddProductHandler(session, cfg));

        exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}