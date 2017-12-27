package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.agh.edu.hibernate.model.Category;
import pl.agh.edu.hibernate.model.Product;
import pl.agh.edu.hibernate.model.Supplier;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

/**
 * Created by sirius on 27.12.17.
 */
public class AddProductHandler extends DefaultRoute {
    public AddProductHandler(Session session, Configuration templateConfiguration) {
        super(session, templateConfiguration);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Category category = session.load(Category.class, Integer.parseInt(request.queryParams("category")));
        Supplier supplier = session.load(Supplier.class, Integer.parseInt(request.queryParams("supplier")));

        if (category == null || supplier == null) {
            throw halt(400, "Invalid references");
        }

        Product product = new Product(
                request.queryParams("product_name"),
                Integer.parseInt(request.queryParams("units_on_stock")),
                supplier,
                category
                );

        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();

        response.redirect("/products");
        return null;
    }
}
