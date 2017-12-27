package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import pl.agh.edu.hibernate.model.Category;
import pl.agh.edu.hibernate.model.Supplier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sirius on 27.12.17.
 */
public class AddProductForm extends DefaultRoute {
    public AddProductForm(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {

        Map<String, Object> params = new HashMap<>();

        List<Category> categories =
                session.createQuery("select c from Category c", Category.class).list();
        params.put("categories", categories);

        List<Supplier> suppliers =
                session.createQuery("select s from Supplier s", Supplier.class).list();
        params.put("suppliers", suppliers);

        return templateEngine.render(
                new ModelAndView(params, "addproduct.ftl"));
    }
}
