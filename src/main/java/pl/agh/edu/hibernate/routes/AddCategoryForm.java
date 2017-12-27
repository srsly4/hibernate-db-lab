package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Collections;

/**
 * Created by sirius on 27.12.17.
 */
public class AddCategoryForm extends DefaultRoute {
    public AddCategoryForm(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return templateEngine.render(
                new ModelAndView(Collections.EMPTY_MAP, "addcategory.ftl"));
    }
}
