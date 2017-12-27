package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.Product;
import pl.agh.edu.hibernate.model.SalesTransaction;
import spark.Request;
import spark.Response;

/**
 * Created by sirius on 27.12.17.
 */
public class TransactionAddProductHandler extends DefaultRoute {
    public TransactionAddProductHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        SalesTransaction transaction = session.load(SalesTransaction.class,
                Integer.parseInt(request.params("transaction")));

        Transaction tx = session.beginTransaction();

        Product product = session.load(Product.class, Integer.parseInt(request.queryParams("product")));
        transaction.addProduct(product);

        session.save(transaction);
        tx.commit();

        response.redirect("/transactions/" + transaction.getTransactionId());
        return null;
    }
}
