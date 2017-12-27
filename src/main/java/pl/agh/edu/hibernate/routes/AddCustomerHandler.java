package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.Customer;
import pl.agh.edu.hibernate.model.Supplier;
import spark.Request;
import spark.Response;

/**
 * Created by sirius on 27.12.17.
 */
public class AddCustomerHandler extends DefaultRoute {
    public AddCustomerHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Customer customer = new Customer(
                request.queryParams("company_name"),
                request.queryParams("street"),
                request.queryParams("city"),
                request.queryParams("zipcode"),
                Integer.parseInt(request.queryParams("discount"))
        );

        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        response.redirect("/customers");
        return null;
    }
}
