package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import pl.agh.edu.hibernate.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sirius on 27.12.17.
 */
public class ProductList extends DefaultRoute {

    public ProductList(Session session, Configuration templates) {
        super(session, templates);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("products",
                session.createQuery("select p from Product p " +
                        "join fetch p.category join fetch p.supplier").list());

        return templateEngine.render(new ModelAndView(params, "products.ftl"));
    }
}
