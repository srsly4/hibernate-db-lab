package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.SalesTransaction;
import spark.Request;
import spark.Response;

import java.util.Date;

/**
 * Created by sirius on 27.12.17.
 */
public class CreateTransactionHandler extends DefaultRoute {
    public CreateTransactionHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        SalesTransaction transaction = new SalesTransaction(
                (int)Math.round(Math.random()*100000),
                1,
                new Date(),
                true
        );

        Transaction tx = session.beginTransaction();
        session.save(transaction);
        tx.commit();

        response.redirect("/transactions/" + transaction.getTransactionId());
        return null;
    }
}
