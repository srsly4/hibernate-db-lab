package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import pl.agh.edu.hibernate.model.Category;
import pl.agh.edu.hibernate.model.SalesTransaction;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sirius on 27.12.17.
 */
public class TransactionList extends DefaultRoute {
    public TransactionList(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("transactions",
                session.createQuery("select p from SalesTransaction p " +
                        "where p.isDraft = false order by p.timestamp desc", SalesTransaction.class).list());

        params.put("drafts",
                session.createQuery("select p from SalesTransaction p " +
                        "where p.isDraft = true order by p.timestamp desc", SalesTransaction.class).list());

        return templateEngine.render(new ModelAndView(params, "transactions.ftl"));
    }
}
