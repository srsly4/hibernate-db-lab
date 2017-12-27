package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.Category;
import pl.agh.edu.hibernate.model.Supplier;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

/**
 * Created by sirius on 27.12.17.
 */
public class AddSupplierHandler extends DefaultRoute {
    public AddSupplierHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Supplier supplier = new Supplier(
                request.queryParams("company_name"),
                request.queryParams("street"),
                request.queryParams("city"),
                request.queryParams("zipcode"),
                request.queryParams("bankaccountnumber")
        );

        Transaction tx = session.beginTransaction();
        session.save(supplier);
        tx.commit();
        response.redirect("/suppliers");
        return null;
    }
}
