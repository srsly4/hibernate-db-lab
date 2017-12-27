package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import pl.agh.edu.hibernate.model.Customer;
import pl.agh.edu.hibernate.model.Product;
import pl.agh.edu.hibernate.model.SalesTransaction;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sirius on 27.12.17.
 */
public class TransactionDetailsForm extends DefaultRoute {
    public TransactionDetailsForm(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        SalesTransaction transaction = session.load(SalesTransaction.class,
                Integer.parseInt(request.params("transaction")));
        Map<String, Object> params = new HashMap<>();
        params.put("transaction", transaction);
        if (transaction.isDraft()) {
            params.put("customers", session.createQuery("from Customer", Customer.class).list());
            params.put("products", session.createQuery("from Product", Product.class).list());
        }

        return templateEngine.render(
                new ModelAndView(params, "transactiondetails.ftl"));
    }
}
