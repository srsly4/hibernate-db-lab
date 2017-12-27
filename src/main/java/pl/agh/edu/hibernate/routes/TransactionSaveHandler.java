package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.Customer;
import pl.agh.edu.hibernate.model.SalesTransaction;
import spark.Request;
import spark.Response;

/**
 * Created by sirius on 27.12.17.
 */
public class TransactionSaveHandler extends DefaultRoute {
    public TransactionSaveHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        SalesTransaction transaction = session.load(SalesTransaction.class,
                Integer.parseInt(request.params("transaction")));

        Customer customer = session.load(Customer.class, Integer.parseInt(request.queryParams("customer")));

        Transaction tx = session.beginTransaction();
        transaction.setQuantity(Integer.parseInt(request.queryParams("quantity")));
        transaction.setTransactionNumber(Integer.parseInt(request.queryParams("transaction_number")));
        transaction.setDraft(false);
        transaction.setCustomer(customer);

        tx.commit();
        response.redirect("/transactions/" + transaction.getTransactionId());
        return null;
    }
}
