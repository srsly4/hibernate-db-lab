package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.Category;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

/**
 * Created by sirius on 27.12.17.
 */
public class AddCategoryHandler extends DefaultRoute {
    public AddCategoryHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String categoryName = request.queryParams("category_name");
        if (categoryName.isEmpty()) {
            throw halt(400, "Empty category name");
        }
        Category category = new Category(categoryName);

        Transaction tx = session.beginTransaction();
        session.save(category);
        tx.commit();
        response.redirect("/categories");
        return null;
    }
}
