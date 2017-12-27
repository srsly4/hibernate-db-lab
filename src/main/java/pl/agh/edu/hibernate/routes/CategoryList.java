package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import pl.agh.edu.hibernate.model.Category;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sirius on 27.12.17.
 */
public class CategoryList extends DefaultRoute {

    public CategoryList(Session session, Configuration templates) {
        super(session, templates);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("categories",
                session.createQuery("select p from Category p", Category.class).list());

        return templateEngine.render(new ModelAndView(params, "categories.ftl"));
    }
}
