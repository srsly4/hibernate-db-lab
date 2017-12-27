package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import pl.agh.edu.hibernate.model.Customer;
import pl.agh.edu.hibernate.model.Supplier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sirius on 27.12.17.
 */
public class CustomerList extends DefaultRoute {

    public CustomerList(Session session, Configuration templates) {
        super(session, templates);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("customers",
                session.createQuery("select p from Customer p", Customer.class).list());

        return templateEngine.render(new ModelAndView(params, "customers.ftl"));
    }
}
